import pymysql
class DaoMem:
    def __init__(self):
        
        self.con = pymysql.connect(host='127.0.0.1', port=3305, user='root', password='python',
                       db='python', charset='utf8') # 한글처리 (charset = 'utf8')
 
# STEP 3: Connection 으로부터 Cursor 생성
        self.cur = self.con.cursor(pymysql.cursors.DictCursor)
    
    def selectList(self):
        sql = "select * from mem"
        self.cur.execute(sql)
    
        list = self.cur.fetchall()
        return list
    

    def selectOne(self,m_id):
        sql = f"select * from mem where m_id='{m_id}'"
        self.cur.execute(sql)
        
        list2 = self.cur.fetchone()
        return list2
        
    def __del__(self):
        self.cur.close()
        self.con.close()
        
    def insert(self,m_id,m_name,tel,address):
        sql = f"insert into mem(m_id,m_name,tel,address) values('{m_id}','{m_name}','{tel}','{address}')"
        
        self.cur.execute(sql)
        
        cnt = self.cur.rowcount
        self.con.commit()
        return cnt
        
    def update(self,m_id,m_name,tel,address):
        sql = f"update mem set m_name='{m_name}',tel='{tel}',address='{address}' where m_id='{m_id}'"
        
        cnt=self.cur.execute(sql)
        self.con.commit()
        return cnt
        
    def delete(self,m_id):
        sql = f"delete from mem where m_id='{m_id}'"
        
        self.cur.execute(sql)
        
        cnt2 = self.cur.rowcount
        self.con.commit()
        return cnt2
                                
if __name__ == '__main__':
    de = DaoMem()
    cnt2 = de.delete("3")
    print("cnt2",cnt2)     