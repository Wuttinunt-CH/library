class BootStrap {

    def init = { servletContext ->

   new library.UserGroup(id_group: "st00",group_name: "นักศึกษา",total_borrow: "10",fine: "10").save()
   new library.UserGroup(id_group: "admin",group_name: "Admin",total_borrow: "15",fine: "10").save()
   new library.UserGroup(id_group: "tc00",group_name: "บุคลากร,เจ้าหน้าที่",total_borrow: "15",fine: "10").save()
   new library.UserGroup(id_group: "general",group_name: "บุคคลทั่วไป",total_borrow: "5",fine: "10").save()
   new library.UserGroup(id_group: "authority",group_name: "บรรณารักษ์",total_borrow: "15",fine: "10").save()

   new library.TypeBook(type: "หนังสือทั่วไป").save()
   new library.TypeBook(type: "หนังสือพิมพ์").save()
   new library.TypeBook(type: "นิยสาร,แมกกาซีน").save()
   new library.TypeBook(type: "การ์ตูน,หนังสือภาพ,หนังสือเด็ก").save()
   new library.TypeBook(type: "ตำราเรียน,วิทยานิพนธ์").save()
   new library.TypeBook(type: "วรรณกรรม,นวนิยาย").save()
   //new library.TypeBook(type: "หนังสือทั่วไป").save()
   //new library.User(username: "admin", prefix: "Mr.", fname: "anuwat", lname: "r", sex: 'm', age: '18', tel: "012-421111", email: "jame@email.com", date_reg: "2015-11-03 09:00:00", password: "1234",group: '1').save()
   //new library.Table_reservations(idcode: "B123456", dates: "2558-10-12 09:00:00", hour: "1", rooms: "กลุ่ม", objective: "นอนเล่น", owner: '1').save()
   new library.Member(username: "ADMIN",password: "1234",fname: "Wuttinunt" ,lname: "Chaoyos").save()
   new library.Member(username: "JAME",password: "1234",fname: "anuwat" ,lname: "...").save()
   new library.Member(username: "TAE",password: "1234",fname: "Wuttinunt" ,lname: "Chaoyos").save()
   new library.Member(username: "BOSS",password: "1234",fname: "atiwat" ,lname: "..").save()
   new library.Member(username: "ONE",password: "1234",fname: "phanat" ,lname: "..").save()
   new library.Member(username: "CHAT",password: "1234",fname: "chatchada" ,lname: "Yanudom").save()
   new library.Member(username: "ARM",password: "1234",fname: "apichat" ,lname: "Seeda").save()
   new library.Book(idBook: "1111111111",nameBook: "เจ้าชายน้อย",publisher: "sut",status: "พร้อมให้ยืม",price: '200',dateReg: "2015-11-03 09:00:00.0",author: "มิกกุ",buildYear: '1994',shelf: "Q6603",detail: "-",dateReturn: "2015-11-03 09:00:00.0",typeBook: '6').save()
   new library.Book(idBook: "0000000002",nameBook: "ตำนานไก่ป่า",publisher: "sut",status: "พร้อมให้ยืม",price: '200',dateReg: "2015-11-03 09:00:00.0",author: "ฮี่ๆ",buildYear: '2015',shelf: "Q6604",detail: "-",dateReturn: "2015-11-03 09:00:00.0",typeBook: '6').save()
   new library.Book(idBook: "0000000004",nameBook: "Calculus I",publisher: "sut",status: "พร้อมให้ยืม",price: '200',dateReg: "2015-11-03 09:00:00.0",author: "KT Op",buildYear: '2016',shelf: "Q7710",detail: "-",dateReturn: "2015-11-03 09:00:00.0",typeBook: '5').save()
   new library.Book(idBook: "0000000005",nameBook: "อาราเล่",publisher: "sut",status: "พร้อมให้ยืม",price: '200',dateReg: "2015-11-03 09:00:00.0",author: "ชินจัง",buildYear: '2014',shelf: "CT6330",detail: "-",dateReturn: "2015-11-03 09:00:00.0",typeBook: '4').save()

   new library.User(username: "ADMIN", prefix: "Mr.", fname: "Bean", lname: "Kumkum", sex: 'M', age: '21', tel: "091-0989916", email: "admin-library@email.com", date_reg: "2016-01-23 10:10:10.0", password: "admin",group: '2').save()
   new library.User(username: "JAME", prefix: "Mr.", fname: "Anuwat", lname: "...", sex: 'M', age: '21', tel: "091-0989916", email: "James.nn@hotmail.com", date_reg: "2016-01-23 10:10:10.0", password: "1234",group: '5').save()
   new library.User(username: "TAE", prefix: "Mr.", fname: "Wuttinunt", lname: "Chaoyod", sex: 'M', age: '21', tel: "0845380145", email: "tazakunk@gmail.com", date_reg: "2016-01-23 10:10:10.0", password: "1234",group: '5').save()
   new library.User(username: "BOSS", prefix: "Mr.", fname: "Atiwat", lname: "...", sex: 'M', age: '21', tel: "091-0989916", email: "boss.atiwut@gmail.com", date_reg: "2016-01-23 10:10:10.0", password: "1234",group: '5').save()
   new library.User(username: "ONE", prefix: "Mr.", fname: "Phanat", lname: "...", sex: 'M', age: '21', tel: "091-0989916", email: "5303phanat@gmail.com", date_reg: "2016-01-23 10:10:10.0", password: "1234",group: '5').save()
   new library.User(username: "CHAT", prefix: "Mrs.", fname: "Chatchada", lname: "...", sex: 'F', age: '21', tel: "091-0989916", email: "chatchada.yanudom@gmail.com", date_reg: "2016-01-23 10:10:10.0", password: "1234",group: '5').save()
   new library.User(username: "ARM", prefix: "Mr.", fname: "Apichat", lname: "...", sex: 'M', age: '21', tel: "091-0989916", email: "armmainsut@gmail.com", date_reg: "2016-01-23 10:10:10.0", password: "1234",group: '5').save()



   new library.User(username: "BON", prefix: "Mr.", fname: "Kittipan", lname: "Prasertsang", sex: 'M', age: '21', tel: "091-0989916", email: "chatchada.yanudom@email.com", date_reg: "2016-01-23 10:10:10.0", password: "2650",group: '1').save()
   new library.User(username: "TEST1", prefix: "Mr.", fname: "aaa", lname: "vbvbvb", sex: 'M', age: '21', tel: "091-0989916", email: "chatchada.yanudom@email.com", date_reg: "2016-01-23 10:10:10.0", password: "123",group: '1').save()
   new library.User(username: "TEST2", prefix: "Mrs.", fname: "ccc", lname: "wwwww", sex: 'F', age: '21', tel: "091-0989916", email: "chatchada.yanudom@email.com", date_reg: "2016-01-23 10:10:10.0", password: "123",group: '4').save()
   new library.User(username: "TEST3", prefix: "Mr.", fname: "www", lname: "rrrr", sex: 'M', age: '21', tel: "091-0989916", email: "chatchada.yanudom@email.com", date_reg: "2016-01-23 10:10:10.0", password: "123",group: '3').save()
   
    }
    def destroy = {
    }
}
