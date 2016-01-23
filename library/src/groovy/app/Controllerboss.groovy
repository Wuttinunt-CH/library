package app
import library.*
class Controllerboss {
void addTodoItemboss(String idtool,String nametool,String number,Date datelend,Date datereturn,String fname,String lname){

        Tabletool tool = new Tabletool()
        tool.setIdtool(idtool)
        tool.setNametool(nametool)
        tool.setNumber(number)
        tool.setDatelend(datelend)
        tool.setDatereturn(datereturn)
        tool.setFname(fname)
        tool.setLname(lname)

        tool = tool.save()

    }
}