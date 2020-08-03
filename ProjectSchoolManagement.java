import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import java.sql.*;
import javax.imageio.ImageIO;
import java.text.SimpleDateFormat;  
import java.sql.Date;
import java.sql.*; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
class ProjectSchoolManagement{
public static void main(String args[]){
JFrame obj=new JFrame();
JFrame frame=new JFrame();
obj.setSize(700,480);
obj.setLayout(null);
obj.setResizable(false);
obj.setTitle("KINZA SHAIKH");
JTextField userNameTxt;
JPasswordField passTxt;
try{


obj.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("mainLogo.JPG")))));
}catch(Exception a){
System.out.println(a);
}

JLabel userName=new JLabel("User Name :");
userName.setBounds(160,125,150,50);
userName.setFont(new Font("Castellar",1,15));

userNameTxt=new JTextField();
userNameTxt.setBounds(300,135,220,30);

JLabel pass=new JLabel("password : ");
pass.setBounds(160,210,200,50);
pass.setFont(new Font("Castellar",1,15));

passTxt=new JPasswordField();
passTxt.setBounds(300,215,220,30);

JButton login=new JButton("Login");
login.addActionListener(new mylistener(userNameTxt,passTxt,obj));
login.setBounds(250,300,100,20);

JButton signup=new JButton("Sign up");
signup.addActionListener(new mylistener(userNameTxt,passTxt,obj));
signup.setBounds(250,340,100,20);

obj.add(userName);
obj.add(userNameTxt);
obj.add(pass);
obj.add(passTxt);
obj.add(login);
obj.add(signup);
obj.setVisible(true);

}}

class mylistener implements ActionListener{
JTextField user;
JPasswordField pass;
JFrame obj;
mylistener(JTextField u,JPasswordField p,JFrame obj)
{
user=u;
pass=p;
this.obj=obj;
}
public void actionPerformed(ActionEvent ae){
JButton find=(JButton)ae.getSource();
String usr=user.getText();
String pas=String.valueOf(pass.getPassword());
if(find.getText().equalsIgnoreCase("sign up")){
userSign ob=new userSign(usr,pas);
ob.signup();
}
else if(find.getText().equalsIgnoreCase("Login")){
userLog ob=new userLog(usr,pas,user,pass);
ob.login();
}


}}





//------------------------------CLASS   OF  SEARCH  BUTTON  AND  ADDMISSION  FORM  BUTTON------------------------------





class main_search implements ActionListener{
JFrame obj;

ImageIcon pic;
ImageIcon editpic;
ImageIcon res;
ImageIcon classs,fe;
public main_search(){

obj=new JFrame();
obj.setSize(700,500);
obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
obj.setLayout(null);
obj.setResizable(false);
pic=new ImageIcon("AddForm.PNG");
editpic=new ImageIcon("Edit.PNG");
res=new ImageIcon("result.PNG");
fe=new ImageIcon("fees.PNG");
classs=new ImageIcon("class.PNG");
Container con=obj.getContentPane();


try{
obj.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("now.PNG")))));
}catch(Exception a){
System.out.println(a);
}

JLabel schoolName=new JLabel("SCHOOL MANAGEMENT SYSTEM");
schoolName.setBounds(80,10,900,30);
schoolName.setFont(new Font("Courier New",1,40));
schoolName.setForeground(Color.WHITE);


JButton AddForm=new JButton(pic);
AddForm.addActionListener(this);
AddForm.setBounds(90,75,150,150);


JButton result=new JButton(res);
result.addActionListener(this);
result.setBounds(480,250,150,150);

JButton cls=new JButton(classs);
cls.addActionListener(this);
cls.setBounds(480,75,150,150);

JButton fee=new JButton(fe);
fee.addActionListener(this);
fee.setBounds(90,250,150,150);

JButton close=new JButton("close");
close.addActionListener(this);
close.setBounds(530,430,100,30);

JButton edit=new JButton(editpic);
edit.addActionListener(this);
edit.setBounds(300,75,150,150);

obj.add(AddForm);
obj.add(edit);
obj.add(cls);
obj.add(fee);
obj.add(result);
//obj.add(close);
obj.add(schoolName);
obj.setBackground(Color.GRAY);
obj.setVisible(true);
}

public void actionPerformed(ActionEvent ae){
JButton find=(JButton)ae.getSource();
String desc = ((ImageIcon)find.getIcon()).getDescription();
if(desc.equals(pic.getDescription()))
{
window w=new window();
}
else if(desc.equals(editpic.getDescription()))
{
Search S=new Search();
}
else if(desc.equals(res.getDescription()))
{
ResultS R=new ResultS();
}
else if(desc.equals(classs.getDescription()))
{
classSearch R=new classSearch();
}
else if(desc.equals(fe.getDescription()))
{
Fees f=new Fees();
}
else if(find.getText().equalsIgnoreCase("close")){
System.exit(0);
}
	}

}





//-------------------------------RESULTS---------------------------

class ResultS{


JFrame obj;

ImageIcon pic;
ImageIcon editpic;
ImageIcon res;
ImageIcon classs;
ResultS(){

obj=new JFrame();
obj.setSize(700,500);
obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
obj.setLayout(null);
obj.setResizable(false);
pic=new ImageIcon("searchRes.PNG");
res=new ImageIcon("addRes.PNG");
Container con=obj.getContentPane();


try{
obj.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("now.png")))));
}catch(Exception a){
System.out.println("Can't find login.png");
}

JLabel schoolName=new JLabel("  RESULTS");
schoolName.setBounds(80,10,900,30);
schoolName.setFont(new Font("Courier New",1,50));
schoolName.setForeground(Color.BLACK);


JButton AddForm=new JButton(pic);
AddForm.addActionListener(new myListenerR(obj));
AddForm.setBounds(510,150,150,150);


JButton result=new JButton(res);
result.addActionListener(new myListenerR(obj));
result.setBounds(110,150,150,150);

JButton close=new JButton("close");
close.addActionListener(new myListenerR(obj));
close.setBounds(530,430,100,30);


obj.add(AddForm);
obj.add(result);
obj.add(schoolName);
//obj.add(close);
obj.setBackground(Color.GRAY);
obj.setVisible(true);

}
}
class myListenerR implements ActionListener{
JFrame d;
myListenerR(JFrame obj){
d=obj;
}
public void actionPerformed(ActionEvent ae){
JButton find=(JButton)ae.getSource();
String desc = ((ImageIcon)find.getIcon()).getDescription();
ResultS ob = new ResultS();
if(desc.equals(ob.pic.getDescription()))
{
Resultt R=new Resultt();
}
else if(desc.equals(ob.res.getDescription()))
{
AddResultt R=new AddResultt();
}
else if(find.getText().equalsIgnoreCase("close")){
d.dispose();
}
	}

}



//------------------FEES----------------------
class Fees implements ActionListener{

JFrame obj;

ImageIcon pic;
ImageIcon editpic;
ImageIcon res;
ImageIcon classs;
JTextField grTxt,amountTxt,totalTxt;
Fees(){

obj=new JFrame();
obj.setSize(700,500);
obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
obj.setLayout(null);
obj.setResizable(false);
pic=new ImageIcon("searchRes.PNG");
res=new ImageIcon("addRes.PNG");

Container con=obj.getContentPane();
JLabel feee=new JLabel("    STUDENT  FEE");
feee.setBounds(80,10,900,30);
feee.setFont(new Font("Courier New",1,50));
feee.setForeground(Color.BLACK);



JLabel gr=new JLabel("GRNo :");
gr.setBounds(160,125,150,50);
gr.setFont(new Font("Castellar",1,15));

grTxt=new JTextField();
grTxt.setBounds(310,135,220,30);

JLabel amount=new JLabel(" Amount : ");
amount.setBounds(160,215,200,50);
amount.setFont(new Font("Castellar",1,15));
//amount.setForeground(Color.BLACK);
amountTxt=new JTextField();
amountTxt.setBounds(310,220,220,30);
amountTxt.setEditable(false);

JLabel total=new JLabel("Total Amount : ");
total.setBounds(160,295,200,50);
total.setFont(new Font("Castellar",1,15));

totalTxt=new JTextField();
totalTxt.setBounds(310,300,220,30);
totalTxt.setText("2000");
totalTxt.setEditable(false);

JButton search=new JButton("Search");
search.addActionListener(this);
search.setBounds(180,350,100,20);


JButton payFee=new JButton("payFee");
payFee.addActionListener(this);
payFee.setBounds(380,350,100,20);

JButton close=new JButton("close");
close.setBounds(470,410,80,15);
close.addActionListener(this);

obj.add(feee);
obj.add(search);
obj.add(payFee);
obj.add(close);
obj.add(gr);
obj.add(grTxt);
obj.add(amount);
obj.add(amountTxt);
obj.add(total);
obj.add(totalTxt);
obj.setBackground(Color.GRAY);
obj.setVisible(true);

}
public void actionPerformed(ActionEvent ae){
String ob=ae.getActionCommand();
int gr=Integer.parseInt(grTxt.getText());
int amount=0;
if(ob.equalsIgnoreCase("close")){
obj.dispose();
}
else if(ob.equalsIgnoreCase("payFee")){
amountTxt.setEditable(true);
try{amount=Integer.parseInt(amountTxt.getText());
}catch(Exception ex)
{
JOptionPane.showMessageDialog(null,"Enter Amount");
}
if(amount>2000)
	{
int a=amount-2000;
JOptionPane.showMessageDialog(null,"Your Remaining amount :"+a);
FeesInsert on=new FeesInsert(gr,2000);
on.insertFee();
	}
else if(amount==2000)
	{
FeesInsert on=new FeesInsert(gr,amount);
on.insertFee();
	}
else
	{
JOptionPane.showMessageDialog(null,"Fees is 2000");
	}

}else if(ob.equalsIgnoreCase("search")){
FeesSearch o=new FeesSearch(gr);
obj.dispose();
o.fee_search();
}


}


}


//----------------CLASS OF  EDITABLE  RECORD  OF  STUDENTS (UPDATE  OPTION) INTERFACE(5)----------------------




class canEdit implements ActionListener{
JFrame ob;
JLabel Addmission;

JLabel name,F_name,surname,address,gr,L_school,R_LeavingSchool,classAddmission,classSec,classSession;
JTextField nameTxt,F_nameTxt,surnameTxt,addressTxt,grTxt,L_schoolTxt,R_LeavingSchoolTxt,classAddmissionTxt,classSecTxt;

JLabel C_num,birth_D;
JTextField classSessionTxt,C_numTxt,birth_DTxt;
String GR_NO;

JButton ok,close,reset;
canEdit(){

ob=new JFrame();
ob.setSize(800,500); 
ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
ob.setLayout(null);
ob.setResizable(false);
Container con=ob.getContentPane();

try{
ob.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("formMain.png")))));
}catch(Exception a){
System.out.println("Can't find login.png");
}



Addmission=new JLabel("UPDATE  STUDENT  RECORD");
Addmission.setBounds(270,23,300,50);
Addmission.setFont(new Font("Courier New",1,25));
Addmission.setForeground(Color.WHITE);

con.setBackground(Color.LIGHT_GRAY);

name=new JLabel("Name : ");
name.setBounds(50,100,100,50);
nameTxt=new JTextField();
nameTxt.setBounds(100,115,250,20);
name.setForeground(Color.WHITE);

F_name=new JLabel("Father Name : ");
F_name.setBounds(355,100,100,50);
F_nameTxt=new JTextField();
F_nameTxt.setBounds(440,116,320,20);
F_name.setForeground(Color.WHITE);


surname=new JLabel("Sur name : ");
surname.setBounds(50,150,100,50);
surnameTxt=new JTextField();
surnameTxt.setBounds(120,165,200,20);
surname.setForeground(Color.WHITE);

address=new JLabel("Home Address : ");
address.setBounds(325,150,100,50);
addressTxt=new JTextField();
addressTxt.setBounds(425,166,340,20);
address.setForeground(Color.WHITE);

gr=new JLabel("G R_No : ");
gr.setBounds(50,200,100,50);
grTxt=new JTextField();
grTxt.setBounds(110,215,100,20);
gr.setForeground(Color.WHITE);
grTxt.setEditable(false);

L_school=new JLabel("Last School : ");
L_school.setBounds(230,200,100,50);
L_schoolTxt=new JTextField();
L_schoolTxt.setBounds(310,216,450,20);
L_school.setForeground(Color.WHITE);

R_LeavingSchool=new JLabel("Reason for leaving school : ");
R_LeavingSchool.setBounds(50,250,200,50);
R_LeavingSchoolTxt=new JTextField();
R_LeavingSchoolTxt.setBounds(210,265,550,20);
R_LeavingSchool.setForeground(Color.WHITE);

classAddmission =new JLabel("Addmission in class : ");
classAddmission.setBounds(50,300,200,50);
classAddmissionTxt=new JTextField();
classAddmissionTxt.setBounds(180,315,100,20);
classAddmission.setForeground(Color.WHITE);

classSec =new JLabel("Section : ");
classSec.setBounds(290,300,200,50);
classSecTxt=new JTextField();
classSecTxt.setBounds(345,315,100,20);
classSec.setForeground(Color.WHITE);

classSession =new JLabel("Session : ");
classSession.setBounds(455,300,200,50);
classSessionTxt=new JTextField();
classSessionTxt.setBounds(515,315,100,20);
classSession.setForeground(Color.WHITE);


C_num =new JLabel("Contact number : ");
C_num.setBounds(50,350,200,50);
C_numTxt=new JTextField();
C_numTxt.setBounds(150,365,150,20);
C_num.setForeground(Color.WHITE);

birth_D =new JLabel("Date Of Birth(DD/MM/YYYY) : ");
birth_D.setBounds(320,350,240,50);
birth_DTxt=new JTextField();
birth_DTxt.setBounds(525,365,240,20);
birth_D.setForeground(Color.WHITE);

JButton update=new JButton("update");
update.setBounds(190,410,80,15);
update.addActionListener(this);

JButton del=new JButton("delete");
del.setBounds(330,410,80,15);
del.addActionListener(this);

JButton close=new JButton("close");
close.setBounds(470,410,80,15);
close.addActionListener(this);

ob.add(Addmission);
ob.add(name);
ob.add(nameTxt);
ob.add(F_name);
ob.add(F_nameTxt);
ob.add(address);
ob.add(addressTxt);
ob.add(surname);
ob.add(surnameTxt);
ob.add(gr);
ob.add(grTxt);
ob.add(L_school);
ob.add(L_schoolTxt);
ob.add(R_LeavingSchool);
ob.add(R_LeavingSchoolTxt);
ob.add(classAddmission);
ob.add(classAddmissionTxt);
ob.add(classSec);
ob.add(classSecTxt);
ob.add(classSession);
ob.add(classSessionTxt);
ob.add(C_num);
ob.add(C_numTxt);
ob.add(birth_D);
ob.add(birth_DTxt);
//ob.add(del);
ob.add(close);
ob.add(update);
ob.setVisible(true);


	}

public void actionPerformed(ActionEvent a){

String obj=a.getActionCommand();

if(obj.equalsIgnoreCase("update"))
{

int grno=Integer.parseInt(grTxt.getText());
String contact=C_numTxt.getText();
String bir=birth_DTxt.getText();
String name=nameTxt.getText();
String F_name=F_nameTxt.getText();
String surname=surnameTxt.getText();
String L_school=L_schoolTxt.getText();
String R_LeavingSchool=R_LeavingSchoolTxt.getText();
String address=addressTxt.getText();
String classAddmission=classAddmissionTxt.getText();
String classSec=classSecTxt.getText();
String classSession=classSessionTxt.getText();
 update_class updateObj = new update_class(name,F_name,surname,grno,contact,bir,L_school,R_LeavingSchool,address,classAddmission,classSec,classSession);
   updateObj.update_Data();

}
else if(obj.equalsIgnoreCase("close"))
	{

ob.dispose();

	}


}
	}





//--------------------CLASS  FOR  NONEDITABLE  RECORD  OF  STUDENTS INTERFACE(4)----------------------





class nonedit implements ActionListener{

JFrame ob;
JLabel Addmission;
JLabel name,F_name,surname,address,gr,L_school,R_LeavingSchool,classAddmission,classSec,classSession;
JTextField nameTxt,F_nameTxt,surnameTxt,addressTxt,grTxt,L_schoolTxt,R_LeavingSchoolTxt,classAddmissionTxt,classSecTxt;

JLabel C_num,birth_D;
JTextField classSessionTxt,C_numTxt,birth_DTxt;

JButton ok,close,reset;
nonedit(){

ob=new JFrame();
ob.setSize(800,500); 
ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
ob.setLayout(null);
ob.setResizable(false);
Container con=ob.getContentPane();


try{
ob.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("mainFORM.jpg")))));
}catch(Exception a){
System.out.println("Can't find login.png");
}



Addmission=new JLabel("STUDENT  RECORD");
Addmission.setBounds(270,23,300,50);
Addmission.setFont(new Font("Courier New",1,25));
Addmission.setForeground(Color.WHITE);

con.setBackground(Color.LIGHT_GRAY);

name=new JLabel("Name : ");
name.setBounds(50,100,100,50);
nameTxt=new JTextField();
nameTxt.setBounds(100,115,250,20);
nameTxt.setEditable(false);
name.setForeground(Color.WHITE);

F_name=new JLabel("Father Name : ");
F_name.setBounds(350,100,100,50);
F_nameTxt=new JTextField();
F_nameTxt.setBounds(435,116,320,20);
F_nameTxt.setEditable(false);
F_name.setForeground(Color.WHITE);


surname=new JLabel("Sur name : ");
surname.setBounds(50,150,100,50);
surnameTxt=new JTextField();
surnameTxt.setBounds(120,165,200,20);
surnameTxt.setEditable(false);
surname.setForeground(Color.WHITE);

address=new JLabel("Home Address : ");
address.setBounds(320,150,100,50);
addressTxt=new JTextField();
addressTxt.setBounds(420,166,340,20);
addressTxt.setEditable(false);
address.setForeground(Color.WHITE);

gr=new JLabel("G R_No : ");
gr.setBounds(50,200,100,50);
grTxt=new JTextField();
grTxt.setBounds(110,215,100,20);
grTxt.setEditable(false);
gr.setForeground(Color.WHITE);

L_school=new JLabel("Last School : ");
L_school.setBounds(230,200,100,50);
L_schoolTxt=new JTextField();
L_schoolTxt.setBounds(310,216,450,20);
L_schoolTxt.setEditable(false);
L_school.setForeground(Color.WHITE);

R_LeavingSchool=new JLabel("Reason for leaving school : ");
R_LeavingSchool.setBounds(50,250,200,50);
R_LeavingSchoolTxt=new JTextField();
R_LeavingSchoolTxt.setBounds(210,265,550,20);
R_LeavingSchoolTxt.setEditable(false);
R_LeavingSchool.setForeground(Color.WHITE);

classAddmission =new JLabel("Addmission in class : ");
classAddmission.setBounds(50,300,200,50);
classAddmissionTxt=new JTextField();
classAddmissionTxt.setBounds(180,315,100,20);
classAddmissionTxt.setEditable(false);
classAddmission.setForeground(Color.WHITE);

classSec =new JLabel("Section : ");
classSec.setBounds(290,300,200,50);
classSecTxt=new JTextField();
classSecTxt.setBounds(345,315,100,20);
classSecTxt.setEditable(false);
classSec.setForeground(Color.WHITE);

classSession =new JLabel("Session : ");
classSession.setBounds(455,300,200,50);
classSessionTxt=new JTextField();
classSessionTxt.setBounds(515,315,100,20);
classSessionTxt.setEditable(false);
classSession.setForeground(Color.WHITE);


C_num =new JLabel("Contact number : ");
C_num.setBounds(50,350,200,50);
C_numTxt=new JTextField();
C_numTxt.setBounds(150,365,150,20);
C_numTxt.setEditable(false);
C_num.setForeground(Color.WHITE);

birth_D =new JLabel("Date Of Birth(DD/MM/YYYY) : ");
birth_D.setBounds(320,350,240,50);
birth_DTxt=new JTextField();
birth_DTxt.setBounds(525,365,240,20);
birth_DTxt.setEditable(false);
birth_D.setForeground(Color.WHITE);


ok=new JButton("Edit");
ok.setBounds(220,410,80,15);
ok.addActionListener(this);

JButton delete=new JButton("delete");
delete.addActionListener(this);
delete.setBounds(360,410,80,15);


close=new JButton("cancel");
close.setBounds(500,410,80,15);
close.addActionListener(this);

ob.add(Addmission);
ob.add(name);
ob.add(nameTxt);
ob.add(F_name);
ob.add(F_nameTxt);
ob.add(address);
ob.add(addressTxt);
ob.add(surname);
ob.add(surnameTxt);
ob.add(gr);
ob.add(grTxt);
ob.add(L_school);
ob.add(L_schoolTxt);
ob.add(R_LeavingSchool);
ob.add(R_LeavingSchoolTxt);
ob.add(classAddmission);
ob.add(classAddmissionTxt);
ob.add(classSec);
ob.add(classSecTxt);
ob.add(classSession);
ob.add(classSessionTxt);
ob.add(C_num);
ob.add(C_numTxt);
ob.add(birth_D);
ob.add(birth_DTxt);
ob.add(ok);
ob.add(close);
//ob.add(delete);
ob.setVisible(true);


}

public void actionPerformed(ActionEvent a){

String obj=a.getActionCommand();
String gr=grTxt.getText();
int GR=Integer.parseInt(gr);
if(obj.equalsIgnoreCase("cancel"))
{
ob.dispose();
}
else if(obj.equalsIgnoreCase("edit"))
{
db_update du=new db_update(GR);
du.data_search();
}

	
	}
}





//------------------CLASS  FOR   STUDENT  SEARCH  INTERFACE(2)Option(2)-----------------------


class classSearch implements ActionListener{

JTextField stuClassTxt;
JFrame cl;

classSearch()
	{
cl = new JFrame();
cl.setSize(800,500); 
cl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
cl.setLayout(null);
cl.setResizable(false);
Container con=cl.getContentPane();
con.setBackground(Color.LIGHT_GRAY);

try{
cl.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("searchBack.jpg")))));
}catch(Exception a){
System.out.println("Can't find login.png");
}

JLabel stuSearch=new JLabel("CLASS  SEARCH");
stuSearch.setBounds(250,23,350,50);
stuSearch.setFont(new Font("Castellar",1,30));
stuSearch.setForeground(Color.WHITE);

JLabel stuClass=new JLabel(" Enter Class : ");
stuClass.setBounds(100,150,180,50);
stuClass.setFont(new Font("Courier New",1,20));
stuClassTxt=new JTextField();
stuClassTxt.setBounds(280,165,330,20);
stuClass.setForeground(Color.WHITE);


JButton ok=new JButton("search");
ok.addActionListener(this);
ok.setBounds(250,320,80,20);

JButton close=new JButton("delete");
close.addActionListener(this);
close.setBounds(400,320,80,20);

JButton del=new JButton("Close");
del.addActionListener(this);
del.setBounds(550,320,80,20);

cl.add(stuClass);
cl.add(stuClassTxt);
cl.add(stuSearch);
cl.add(ok);
//cl.add(close);
cl.add(del);
cl.setVisible(true);

}
public void actionPerformed(ActionEvent a){

String clo=a.getActionCommand();
JButton SearchStu=(JButton)a.getSource();
String cls=(stuClassTxt.getText());
if(SearchStu.getText().equals("search"))
{
searhClass obj=new searhClass(cls);
//obj.data_search();
}
else if(SearchStu.getText().equalsIgnoreCase("Close"))
{
cl.dispose();
}



}
}

//-------------------------------SEARCH_RESULT-------------------------

class Resultt implements ActionListener{
JFrame resu;
JTextField stuGRTxt,stuNameTxt,stuClassTxt,stuSecTxt,
scienceTxt,mathsTxt,engTxt,islamiatTxt,psTxt,urduTxt,drawTxt,tMarksTxt,gMarksTxt;
Resultt(){

resu = new JFrame();
resu.setSize(800,500); 
resu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
resu.setLayout(null);
resu.setResizable(false);
Container con=resu.getContentPane();
con.setBackground(Color.LIGHT_GRAY);

try{
resu.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("searchBack.JPG")))));
}catch(Exception a){
System.out.println("Can't find login.png");
}

JLabel pf=new JLabel("  SEARCH RESULTS");
pf.setBounds(250,23,350,60);
pf.setFont(new Font("Castellar",1,30));
pf.setForeground(Color.WHITE);

JLabel sub=new JLabel("Subject ");
sub.setBounds(420,70,180,50);
sub.setFont(new Font("Courier New",1,25));
sub.setForeground(Color.WHITE);

JLabel marks=new JLabel("Marks ");
marks.setBounds(620,70,180,50);
marks.setFont(new Font("Courier New",1,25));
marks.setForeground(Color.WHITE);


JLabel science=new JLabel("Science ");
science.setBounds(420,120,180,50);
science.setFont(new Font("Courier New",1,17));
scienceTxt=new JTextField();
scienceTxt.setBounds(620,135,120,20);
science.setForeground(Color.WHITE);
scienceTxt.setEditable(false);


JLabel maths=new JLabel("Maths ");
maths.setBounds(420,150,180,50);
maths.setFont(new Font("Courier New",1,17));
mathsTxt=new JTextField();
mathsTxt.setBounds(620,165,120,20);
maths.setForeground(Color.WHITE);
mathsTxt.setEditable(false);


JLabel eng=new JLabel("English ");
eng.setBounds(420,180,180,50);
eng.setFont(new Font("Courier New",1,17));
engTxt=new JTextField();
engTxt.setBounds(620,195,120,20);
eng.setForeground(Color.WHITE);
engTxt.setEditable(false);

JLabel urdu=new JLabel("Urdu ");
urdu.setBounds(420,210,180,50);
urdu.setFont(new Font("Courier New",1,17));
urduTxt=new JTextField();
urduTxt.setBounds(620,225,120,20);
urdu.setForeground(Color.WHITE);
urduTxt.setEditable(false);

JLabel ps=new JLabel("SocialStudies ");
ps.setBounds(420,240,180,50);
ps.setFont(new Font("Courier New",1,17));
psTxt=new JTextField();
psTxt.setBounds(620,255,120,20);
ps.setForeground(Color.WHITE);
psTxt.setEditable(false);

JLabel islamiat=new JLabel("Islamiat ");
islamiat.setBounds(420,270,180,50);
islamiat.setFont(new Font("Courier New",1,17));
islamiatTxt=new JTextField();
islamiatTxt.setBounds(620,285,120,20);
islamiat.setForeground(Color.WHITE);
islamiatTxt.setEditable(false);

JLabel draw=new JLabel("Drawing ");
draw.setBounds(420,300,180,50);
draw.setFont(new Font("Courier New",1,17));
drawTxt=new JTextField();
drawTxt.setBounds(620,315,120,20);
draw.setForeground(Color.WHITE);
drawTxt.setEditable(false);

JLabel stuName=new JLabel("Student name : ");
stuName.setBounds(100,100,180,50);
stuName.setFont(new Font("Courier New",1,15));
stuNameTxt=new JTextField();
stuNameTxt.setBounds(230,115,120,20);
stuName.setForeground(Color.WHITE);


JLabel stuGr=new JLabel("Student GR  : ");
stuGr.setBounds(100,150,180,50);
stuGr.setFont(new Font("Courier New",1,15));
stuGRTxt=new JTextField();
stuGRTxt.setBounds(230,165,120,20);
stuGr.setForeground(Color.WHITE);

JLabel stuClass=new JLabel("Class    : ");
stuClass.setBounds(100,200,180,50);
stuClass.setFont(new Font("Courier New",1,15));
stuClassTxt=new JTextField();
stuClassTxt.setBounds(230,215,120,20);
stuClass.setForeground(Color.WHITE);
stuClassTxt.setEditable(false);

JLabel stuSec=new JLabel("Section   : ");
stuSec.setBounds(100,250,180,50);
stuSec.setFont(new Font("Courier New",1,15));
stuSecTxt=new JTextField();
stuSecTxt.setBounds(230,265,120,20);
stuSec.setForeground(Color.WHITE);
stuSecTxt.setEditable(false);


JLabel tMarks=new JLabel("Total Marks : ");
tMarks.setBounds(100,350,180,50);
tMarks.setFont(new Font("Courier New",1,17));
tMarksTxt=new JTextField();
tMarksTxt.setBounds(245,365,90,20);
tMarks.setForeground(Color.WHITE);
tMarksTxt.setEditable(false);
tMarksTxt.setText("700");

JLabel gMarks=new JLabel("Obtained Marks: ");
gMarks.setBounds(100,400,180,50);
gMarks.setFont(new Font("Courier New",1,17));
gMarksTxt=new JTextField();
gMarksTxt.setBounds(242,415,90,20);
gMarks.setForeground(Color.WHITE);
gMarksTxt.setEditable(false);


JButton close=new JButton("close");
close.addActionListener(this);
close.setBounds(590,430,80,20);

JButton ch=new JButton("Check");
ch.addActionListener(this);
ch.setBounds(430,430,80,20);


resu.add(ch);
resu.add(close);
resu.add(urdu);
resu.add(urduTxt);
resu.add(ps);
resu.add(psTxt);
resu.add(draw);
resu.add(drawTxt);
resu.add(islamiat);
resu.add(islamiatTxt);
resu.add(marks);
resu.add(sub);
resu.add(pf);
resu.add(stuNameTxt);
resu.add(stuGr);
resu.add(stuGRTxt);
//resu.add(stuClass);
//resu.add(stuClassTxt);
//resu.add(stuSec);
//resu.add(stuSecTxt);
resu.add(science);
resu.add(scienceTxt);
resu.add(tMarks);
resu.add(tMarksTxt);
resu.add(gMarks);
resu.add(gMarksTxt);
resu.add(maths);
resu.add(mathsTxt);
resu.add(eng);
resu.add(engTxt);
resu.add(stuName);
resu.setVisible(true);

}
public void actionPerformed(ActionEvent a){
JButton resStu=(JButton)a.getSource();
int gr=Integer.parseInt(stuGRTxt.getText());
String n=stuNameTxt.getText();
if(resStu.getText().equals("close"))
{resu.dispose();
}
else if(resStu.getText().equals("Check"))
{

searchResult obj=new searchResult(gr,n);
resu.dispose();obj.data_search();

System.out.println("in else if");

}
}
}


//----------------------------------------ADD RESULT-------------------------------


class AddResultt implements ActionListener{
JFrame resu;
JTextField stuGRTxt,stuNameTxt,stuClassTxt,stuSecTxt,
scienceTxt,mathsTxt,engTxt,islamiatTxt,psTxt,urduTxt,drawTxt,gMarksTxt,tMarksTxt;
AddResultt(){

resu = new JFrame();
resu.setSize(800,500); 
resu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
resu.setLayout(null);
resu.setResizable(false);
Container con=resu.getContentPane();
con.setBackground(Color.LIGHT_GRAY);

try{
resu.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("searchBack.JPG")))));
}catch(Exception a){
System.out.println("Can't find login.png");
}


JLabel pf=new JLabel(" ADD  RESULTS");
pf.setBounds(250,23,350,60);
pf.setFont(new Font("Castellar",1,30));
pf.setForeground(Color.WHITE);

JLabel sub=new JLabel("Subject ");
sub.setBounds(420,70,180,50);
sub.setFont(new Font("Courier New",1,25));
sub.setForeground(Color.WHITE);

JLabel marks=new JLabel("Marks ");
marks.setBounds(620,70,180,50);
marks.setFont(new Font("Courier New",1,25));
marks.setForeground(Color.WHITE);

JLabel science=new JLabel("Science ");
science.setBounds(420,120,180,50);
science.setFont(new Font("Courier New",1,17));
scienceTxt=new JTextField();
scienceTxt.setBounds(620,135,120,20);
science.setForeground(Color.WHITE);

JLabel tMarks=new JLabel("Total Marks : ");
tMarks.setBounds(100,350,180,50);
tMarks.setFont(new Font("Courier New",1,17));
tMarksTxt=new JTextField();
tMarksTxt.setBounds(245,365,90,20);
tMarks.setForeground(Color.WHITE);
tMarksTxt.setEditable(false);
tMarksTxt.setText("700");

JLabel gMarks=new JLabel("Obtained Marks: ");
gMarks.setBounds(100,400,180,50);
gMarks.setFont(new Font("Courier New",1,17));
gMarksTxt=new JTextField();
gMarksTxt.setBounds(242,415,90,20);
gMarks.setForeground(Color.WHITE);
gMarksTxt.setEditable(false);

JLabel maths=new JLabel("Maths ");
maths.setBounds(420,150,180,50);
maths.setFont(new Font("Courier New",1,17));
mathsTxt=new JTextField();
mathsTxt.setBounds(620,165,120,20);
maths.setForeground(Color.WHITE);


JLabel eng=new JLabel("English ");
eng.setBounds(420,180,180,50);
eng.setFont(new Font("Courier New",1,17));
engTxt=new JTextField();
engTxt.setBounds(620,195,120,20);
eng.setForeground(Color.WHITE);

JLabel urdu=new JLabel("Urdu ");
urdu.setBounds(420,210,180,50);
urdu.setFont(new Font("Courier New",1,17));
urduTxt=new JTextField();
urduTxt.setBounds(620,225,120,20);
urdu.setForeground(Color.WHITE);

JLabel ps=new JLabel("SocialStudies ");
ps.setBounds(420,240,180,50);
ps.setFont(new Font("Courier New",1,17));
psTxt=new JTextField();
psTxt.setBounds(620,255,120,20);
ps.setForeground(Color.WHITE);

JLabel islamiat=new JLabel("Islamiat ");
islamiat.setBounds(420,270,180,50);
islamiat.setFont(new Font("Courier New",1,17));
islamiatTxt=new JTextField();
islamiatTxt.setBounds(620,285,120,20);
islamiat.setForeground(Color.WHITE);

JLabel draw=new JLabel("Drawing ");
draw.setBounds(420,300,180,50);
draw.setFont(new Font("Courier New",1,17));
drawTxt=new JTextField();
drawTxt.setBounds(620,315,120,20);
draw.setForeground(Color.WHITE);

JLabel stuName=new JLabel("Student name : ");
stuName.setBounds(100,100,180,50);
stuName.setFont(new Font("Courier New",1,15));
stuNameTxt=new JTextField();
stuNameTxt.setBounds(230,115,120,20);
stuName.setForeground(Color.WHITE);


JLabel stuGr=new JLabel("Student GR  : ");
stuGr.setBounds(100,150,180,50);
stuGr.setFont(new Font("Courier New",1,15));
stuGRTxt=new JTextField();
stuGRTxt.setBounds(230,165,120,20);
stuGr.setForeground(Color.WHITE);

JLabel stuClass=new JLabel("Class    : ");
stuClass.setBounds(100,200,180,50);
stuClass.setFont(new Font("Courier New",1,15));
stuClassTxt=new JTextField();
stuClassTxt.setBounds(230,215,120,20);
stuClass.setForeground(Color.WHITE);

JLabel stuSec=new JLabel("Section   : ");
stuSec.setBounds(100,250,180,50);
stuSec.setFont(new Font("Courier New",1,15));
stuSecTxt=new JTextField();
stuSecTxt.setBounds(230,265,120,20);
stuSec.setForeground(Color.WHITE);

JButton close=new JButton("close");
close.addActionListener(this);
close.setBounds(590,430,80,20);

JButton ad=new JButton("Add");
ad.addActionListener(this);
ad.setBounds(430,430,80,20);

resu.add(ad);
resu.add(close);
resu.add(urdu);
resu.add(urduTxt);
resu.add(ps);
resu.add(tMarks);
resu.add(tMarksTxt);
resu.add(gMarks);
resu.add(gMarksTxt);
resu.add(psTxt);
resu.add(draw);
resu.add(drawTxt);
resu.add(islamiat);
resu.add(islamiatTxt);
resu.add(marks);
resu.add(sub);
resu.add(pf);
resu.add(stuNameTxt);
resu.add(stuGr);
resu.add(stuGRTxt);
//resu.add(stuClass);
//resu.add(stuClassTxt);
//resu.add(stuSec);
//resu.add(stuSecTxt);
resu.add(science);
resu.add(scienceTxt);
resu.add(maths);
resu.add(mathsTxt);
resu.add(eng);
resu.add(engTxt);
resu.add(stuName);
resu.setVisible(true);
}
public void actionPerformed(ActionEvent a){
JButton resStu=(JButton)a.getSource();
if(resStu.getText().equals("close"))
{resu.dispose();
}
else if(resStu.getText().equals("Add"))

{
//System.out.println("In else if");
String nameT=stuNameTxt.getText();
int grno=Integer.parseInt(stuGRTxt.getText());
int tMarksT=Integer.parseInt(tMarksTxt.getText());
//int oMarksT=Integer.parseInt(gMarksTxt.getText());
int scienceT=Integer.parseInt(scienceTxt.getText());

int mathsT=Integer.parseInt(mathsTxt.getText());

int islamiatT=Integer.parseInt(islamiatTxt.getText());

int engT=Integer.parseInt(engTxt.getText());
int urduT=Integer.parseInt(urduTxt.getText());
int psT=Integer.parseInt(psTxt.getText());
int drawT=Integer.parseInt(drawTxt.getText());

Rdatabase obj=new Rdatabase(nameT,grno,tMarksT,1,scienceT,mathsT,islamiatT,engT,urduT,psT,drawT);
try{obj.data_handler();}catch(Exception e){}
}


}

}




class Search implements ActionListener{
JTextField stuGRTxt,stuNameTxt;
JFrame search;

Search()
	{
search = new JFrame();
search.setSize(800,500); 
search.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
search.setLayout(null);
search.setResizable(false);
Container con=search.getContentPane();
con.setBackground(Color.LIGHT_GRAY);

try{
search.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("searchBack.jpg")))));
}catch(Exception a){
System.out.println("Can't find login.png");
}

JLabel stuSearch=new JLabel("STUDENT  SEARCH");
stuSearch.setBounds(250,23,350,50);
stuSearch.setFont(new Font("Castellar",1,30));
stuSearch.setForeground(Color.WHITE);

JLabel stuName=new JLabel("Student name : ");
stuName.setBounds(100,150,180,50);
stuName.setFont(new Font("Courier New",1,20));
stuNameTxt=new JTextField();
stuNameTxt.setBounds(280,165,330,20);
stuName.setForeground(Color.WHITE);


JLabel stuGR=new JLabel("GR-NO : ");
stuGR.setBounds(130,220,150,50);
stuGR.setFont(new Font("Courier New",1,20));
stuGRTxt=new JTextField();
stuGRTxt.setBounds(280,240,330,20);
stuGR.setForeground(Color.WHITE);

JButton ok=new JButton("search");
ok.addActionListener(this);
ok.setBounds(250,320,80,20);

JButton close=new JButton("delete");
close.addActionListener(this);
close.setBounds(400,320,80,20);

JButton del=new JButton("Close");
del.addActionListener(this);
del.setBounds(550,320,80,20);

search.add(stuName);
search.add(stuNameTxt);
search.add(stuSearch);
search.add(stuGR);
search.add(stuGRTxt);
search.add(ok);
search.add(close);
search.add(del);
search.setVisible(true);

	}
JFrame object=search;
public void actionPerformed(ActionEvent a){

String clo=a.getActionCommand();
JButton SearchStu=(JButton)a.getSource();
int gr=Integer.parseInt(stuGRTxt.getText());
String n=stuNameTxt.getText();
if(SearchStu.getText().equals("search"))
{
searchDataBase obj=new searchDataBase(gr);
obj.data_search();
}
else if(SearchStu.getText().equals("delete"))
{
searchDataBase obj=new searchDataBase(gr);
obj.db_delete();
}
else if(SearchStu.getText().equalsIgnoreCase("Close"))
{
search.dispose();
}

}}






//----------------------CLASS  FOR  ADDMISSION  FORM  INTERFACE(2)Option(1)----------------------





class window implements ActionListener{
JFrame ob=new JFrame();
JLabel Addmission;


JLabel name,F_name,surname,address,gr,L_school,R_LeavingSchool,classAddmission,classSec,classSession;
JTextField nameTxt,F_nameTxt,surnameTxt,addressTxt,grTxt,L_schoolTxt,R_LeavingSchoolTxt,classAddmissionTxt,classSecTxt;

JLabel C_num,birth_D;
JTextField classSessionTxt,C_numTxt,birth_DTxt;

JButton ok,close,reset;
window(){

ob.setSize(800,500); 
ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
ob.setLayout(null);
ob.setResizable(false);
Container con=ob.getContentPane();



try{
ob.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("finalForm.png")))));
}catch(Exception a){
System.out.println("Can't find login.png");
}


Addmission=new JLabel("NEW ADDMISSION FORM");
Addmission.setBounds(270,23,300,50);
Addmission.setFont(new Font("Courier New",1,25));
Addmission.setForeground(Color.WHITE);

con.setBackground(Color.LIGHT_GRAY);

name=new JLabel("Name : ");
name.setBounds(50,100,100,50);
nameTxt=new JTextField();
nameTxt.setBounds(100,115,250,20);
name.setForeground(Color.WHITE);

F_name=new JLabel("Father Name : ");
F_name.setBounds(355,100,100,50);
F_nameTxt=new JTextField();
F_nameTxt.setBounds(440,116,320,20);
F_name.setForeground(Color.WHITE);


surname=new JLabel("Sur name : ");
surname.setBounds(50,150,100,50);
surnameTxt=new JTextField();
surnameTxt.setBounds(120,165,200,20);
surname.setForeground(Color.WHITE);

address=new JLabel("Home Address : ");
address.setBounds(325,150,100,50);
addressTxt=new JTextField();
addressTxt.setBounds(425,166,340,20);
address.setForeground(Color.WHITE);

gr=new JLabel("G R_No : ");
gr.setBounds(50,200,100,50);
grTxt=new JTextField();
grTxt.setBounds(110,215,100,20);
gr.setForeground(Color.WHITE);

L_school=new JLabel("Last School : ");
L_school.setBounds(230,200,100,50);
L_schoolTxt=new JTextField();
L_schoolTxt.setBounds(310,216,450,20);
L_school.setForeground(Color.WHITE);

R_LeavingSchool=new JLabel("Reason for leaving school : ");
R_LeavingSchool.setBounds(50,250,200,50);
R_LeavingSchoolTxt=new JTextField();
R_LeavingSchoolTxt.setBounds(210,265,550,20);
R_LeavingSchool.setForeground(Color.WHITE);

classAddmission =new JLabel("Addmission in class : ");
classAddmission.setBounds(50,300,200,50);
classAddmissionTxt=new JTextField();
classAddmissionTxt.setBounds(180,315,100,20);
classAddmission.setForeground(Color.WHITE);

classSec =new JLabel("Section : ");
classSec.setBounds(290,300,200,50);
classSecTxt=new JTextField();
classSecTxt.setBounds(345,315,100,20);
classSec.setForeground(Color.WHITE);

classSession =new JLabel("Session : ");
classSession.setBounds(455,300,200,50);
classSessionTxt=new JTextField();
classSessionTxt.setBounds(515,315,100,20);
classSession.setForeground(Color.WHITE);


C_num =new JLabel("Contact number : ");
C_num.setBounds(50,350,200,50);
C_numTxt=new JTextField();
C_numTxt.setBounds(150,365,150,20);
C_num.setForeground(Color.WHITE);

birth_D =new JLabel("Date Of Birth(DD/MM/YYYY) : ");
birth_D.setBounds(320,350,240,50);
birth_DTxt=new JTextField();
birth_DTxt.setBounds(525,365,240,20);
birth_D.setForeground(Color.WHITE);

ok=new JButton("submit");
ok.setBounds(220,410,80,15);
ok.addActionListener(this);

close=new JButton("close");
close.setBounds(360,410,80,15);
close.addActionListener(this);

reset=new JButton("reset");
reset.setBounds(490,410,80,15);
reset.addActionListener(this);

ob.add(Addmission);
ob.add(name);
ob.add(nameTxt);
ob.add(F_name);
ob.add(F_nameTxt);
ob.add(address);
ob.add(addressTxt);
ob.add(surname);
ob.add(surnameTxt);
ob.add(gr);
ob.add(grTxt);
ob.add(L_school);
ob.add(L_schoolTxt);
ob.add(R_LeavingSchool);
ob.add(R_LeavingSchoolTxt);
ob.add(classAddmission);
ob.add(classAddmissionTxt);
ob.add(classSec);
ob.add(classSecTxt);
ob.add(classSession);
ob.add(classSessionTxt);
ob.add(C_num);
ob.add(C_numTxt);
ob.add(birth_D);
ob.add(birth_DTxt);
ob.add(ok);
ob.add(close);
ob.add(reset);
ob.setVisible(true);


}

public void actionPerformed(ActionEvent a){

String ob1=a.getActionCommand();

if(ob1.equalsIgnoreCase("close"))
{

ob.dispose();

}
else if(ob1.equalsIgnoreCase("submit"))
{
int grno=Integer.parseInt(grTxt.getText());
int contact=Integer.parseInt(C_numTxt.getText());
String bir=birth_DTxt.getText();
String name=nameTxt.getText();
String F_name=F_nameTxt.getText();
String surname=surnameTxt.getText();
String L_school=L_schoolTxt.getText();
String R_LeavingSchool=R_LeavingSchoolTxt.getText();
String address=addressTxt.getText();
String classAddmission=classAddmissionTxt.getText();
String classSec=classSecTxt.getText();
String classSession=classSessionTxt.getText();

 database obj = new database(name,F_name,surname,grno,contact,bir,L_school,R_LeavingSchool,
address,classAddmission,classSec,classSession);
   try{obj.data_handler();}catch(Exception ex){System.out.println("now");System.out.println(ex);}
}
else if(ob1.equalsIgnoreCase("reset"))
{
nameTxt.setText(null);
F_nameTxt.setText(null);
addressTxt.setText(null);
surnameTxt.setText(null);
grTxt.setText(null);
L_schoolTxt.setText(null);
R_LeavingSchoolTxt.setText(null);
classAddmissionTxt.setText(null);
C_numTxt.setText(null);
birth_DTxt.setText(null);
classSecTxt.setText(null);
classSessionTxt.setText(null);
}

	}

}





//--------------------------CLASS FOR  INSERTING  INTO  DATABSE----------------------------------





 class database{

Statement st;
Connection con;
PreparedStatement ps;
String name,fatherName,address,surName,leavingSchool,r_leavingSchool,className,sec,session;
int gr,contactNum;
String birth;
PreparedStatement stmt;
String cont;
database(String nameT,String F_nameT,String surnameT,int grno,int contact,String bir,String L_schoolT,String R_LeavingSchoolT,
String addressT,String classAddmissionT,String classSecT,String classSessionT){
gr=grno;
name=nameT;
fatherName=F_nameT;
address=addressT;
surName=surnameT;
leavingSchool=L_schoolT;
r_leavingSchool=R_LeavingSchoolT;
className=classAddmissionT; 
sec=classSecT; 
session=classSessionT; 
contactNum=contact;
birth=bir;
con=null;
ps=null;
cont = Integer.toString(contactNum);
//stmt=null;
	}
 public void data_handler()throws SQLException{
  try
	{
  System.out.println("Inserted");
  Class.forName("com.mysql.cj.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"project"+"? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","143kinza"); 
String sql="INSERT INTO classes"
			+"(grno,name,fatherName,address,surname,prevSchool,reasonForLeaving,classs,section,session,contactNum,birthDate)"
			+" VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

			ps=con.prepareStatement(sql);
			ps.setInt(1,gr);
			ps.setString(2,name);
			ps.setString(3,fatherName);
			ps.setString(4,address);
			ps.setString(5,surName);
			ps.setString(6,leavingSchool);
			ps.setString(7,r_leavingSchool);
			ps.setString(8,className);
			ps.setString(9,sec);
			ps.setString(10,session);
			ps.setString(11,"0"+cont);
			ps.setString(12,birth);
                	ps.executeUpdate();
     
    			JOptionPane.showMessageDialog(null,"You are enrolled Thank You! . Press OK.");   
 }
catch(Exception e){
System.out.println(e);
JOptionPane.showMessageDialog(null,"GR_NO is already given Change GR_NO");   
}

try{con.close();
//st.close();
stmt.close();
}catch(Exception ex){}

 	}
}
//-------------INSERT INTO FEES--------------------------

class FeesInsert{

Statement st;
Connection con;
PreparedStatement ps;
int gr,paidAmount;
FeesInsert(int grno,int amount)
{

gr=grno;
paidAmount=amount;
}

public void insertFee(){
try{
Class.forName("com.mysql.cj.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"project"+"? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","143kinza"); 
String sql="INSERT INTO fees"
			+"(grno,paidAmount)"
			+" VALUES (?,?)";

			ps=con.prepareStatement(sql);
			ps.setInt(1,gr);
			ps.setInt(2,paidAmount);
			ps.executeUpdate();
     
    			JOptionPane.showMessageDialog(null,"Fees Paid ,Thank You! . Press OK.");   
 }
catch(Exception e){
System.out.println(e);
JOptionPane.showMessageDialog(null,"Wrong GRNo");   
}

try{con.close();
//st.close();
ps.close();
}catch(Exception ex){}

}


}




//-------------------INSERT INTO USERS---------------------------

class userSign{
Statement st;
Connection con;
PreparedStatement ps;
String n,p;
userSign(String name,String pass)
{n=name;
p=pass;
}

public void signup(){
try{
Class.forName("com.mysql.cj.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"project"+"? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","143kinza"); 
String sql="INSERT INTO Users"
			+"(name,password)"
			+" VALUES (?,?)";

			ps=con.prepareStatement(sql);
			ps.setString(1,n);
			ps.setString(2,p);
			ps.executeUpdate();
     
    			JOptionPane.showMessageDialog(null,"Thank You! . Press OK.");   
 }
catch(Exception e){
System.out.println(e);
JOptionPane.showMessageDialog(null,"User already exists");   
}

try{con.close();
//st.close();
ps.close();
}catch(Exception ex){}

}

}


//---------------------RESULT_____DATABASE---------------------------
 class Rdatabase{

Statement st;
Connection con;
PreparedStatement ps;
String name;
int gr,tMarks,oMarks,science,maths,islamiat,eng,urdu,pss,draw;
PreparedStatement stmt;
String cont;
Rdatabase(String nameT,int grno,int tMarksT,int oMarksT,int scienceT,int mathsT,int islamiatT,int engT,int urduT,int psT,int drawT){
gr=grno;
tMarks=tMarksT;
oMarks=oMarksT;
science=scienceT;
maths=mathsT;
islamiat=islamiatT;
eng=engT;
urdu=urduT;
pss=psT;
draw=drawT;
name=nameT;

con=null;
ps=null;
//stmt=null;
	}
 public void data_handler()throws SQLException{
  try
	{
  System.out.println("In results");
  Class.forName("com.mysql.cj.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"project"+"? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","143kinza"); 
String sql="INSERT INTO results"
			+"(grno,Total_marks,name,science,maths,eng,urdu,socialStudies,islamiat,drawing,obtainedMarks)"
			+" VALUES (?,?,?,?,?,?,?,?,?,?,?)";
int sum=(science+maths+eng+urdu+pss+islamiat+draw);
System.out.println(sum);
			ps=con.prepareStatement(sql);
			ps.setInt(1,gr);
			ps.setInt(2,tMarks);
			ps.setString(3,name);
			ps.setInt(4,science);
			ps.setInt(5,maths);
			ps.setInt(6,eng);
			ps.setInt(7,urdu);
			ps.setInt(8,pss);
			ps.setInt(9,islamiat);
			ps.setInt(10,draw);
			ps.setInt(11,sum);
                	ps.executeUpdate();
     
    			JOptionPane.showMessageDialog(null,"Result is Added Thank You! . Press OK.");   
 }
catch(Exception e){
System.out.println(e);
JOptionPane.showMessageDialog(null,"ERROR!!");   
}

try{con.close();
//st.close();
ps.close();
}catch(Exception ex){}

 	}
}

//---------------------FEES SEARCH----------------------------
class FeesSearch{


Statement st;
Connection con;
ResultSet rs;
String grNo;
Fees ob;
FeesSearch(int gr){

System.out.println("in constructor");
//System.out.println(gr);
grNo=Integer.toString(gr);
}
 boolean flag=false;

 public void fee_search()
		{
  try
	{

System.out.println("in search");
  Class.forName("com.mysql.cj.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"project"+"? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","143kinza"); 
  st=con.createStatement();
  String value="select paidAmount from fees where grno=" +grNo;
  
   


  rs=st.executeQuery(value);
  while(rs.next())
	{
  flag=true;
  ob=new Fees();
  System.out.println("in while");
  String a=""+rs.getInt(1);
  ob.amountTxt.setText(a);
  ob.grTxt.setText(grNo);
}//while

JOptionPane.showMessageDialog(null,"FEES PAID!");

if(!flag)
JOptionPane.showMessageDialog(null,"GR_NO is wrong");

	}//try

catch(Exception e){
JOptionPane.showMessageDialog(null,"GR_NO is wrong");System.out.println(e);
	}

try
	{
con.close();
st.close();
rs.close();
	}
catch(Exception ex)
{}
//now();
}



}



//-----------USERS LOGIN SEARCH-------------------------------

class userLog extends ProjectSchoolManagement{


Statement st;
Connection con;
ResultSet rs;
String grNo;
String n,p;
int see;
JTextField us;JPasswordField ps;
userLog(String name,String pass,JTextField u,JPasswordField paas){
n=name;
p=pass;
us=u;
ps=paas;
}
 boolean flag=false;

 public void login()
		{
  try
	{

System.out.println("in search");
  Class.forName("com.mysql.cj.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"project"+"? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","143kinza"); 
  st=con.createStatement();
  String value="select name , password from users";
  
   

  rs=st.executeQuery(value);
  while(rs.next())
	{
  flag=true;

 System.out.println("in while");
  String na=""+rs.getString(1);
  String pa=""+rs.getString(2);



if(n.equalsIgnoreCase(na)&&p.equalsIgnoreCase(pa))
	{
	
see=1;
break;
	

	}
else 	{


see=0;
	}




	}//while
if(see==0)
{
JOptionPane.showMessageDialog(null,"Incorrect UserName or password");
}
else if(see==1)
{
main_search m=new main_search();
}
if(!flag)
JOptionPane.showMessageDialog(null,"ERROR");

	}//try

catch(Exception e){
JOptionPane.showMessageDialog(null,"ERROR");System.out.println(e);
	}

try
	{
con.close();
st.close();
rs.close();
	}
catch(Exception ex)
{}
//now();
}



}

//----------------------------SEARCH CLASS------------------------

class searhClass{

static JFrame jf =new JFrame();
static JButton Check_Button=new JButton("check");
	   static JButton Cancel=new JButton("Cancel");
	static JButton Back=new JButton("Back");
	
        static Object[] columns={"GrNo "," Name "," FatherName "," Address "," SurName "," PrevSchool "," ReasonForLeaving "," Class "," Section "," Session "," ContactNum "," BirthDate "};
        static DefaultTableModel model=new DefaultTableModel();
	static JTable table=new JTable();
	static JScrollPane pane;
	static JSeparator s = new JSeparator();
	static Object[] row=new Object[12];
        searhClass(){}
        searhClass(String anything){
String cl=anything;
        jf.setSize(800,500);
        jf.setVisible(true);
        jf.setLayout(null);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.setRowHeight(50);
		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.BLACK);
		table.setFont(new Font("Calibri",1,10));
		pane=new JScrollPane(table);
		pane.setBounds(0,0,780,430);
		Cancel.setBounds(450,440,80,15);
		Check_Button.setBounds(200,440,80,15);
               jf.add(pane);
		jf.add(Check_Button);Check_Button.addActionListener(new ListenToSearch(cl));
		jf.add(Cancel);Cancel.addActionListener(new ListenToSearch());
                jf.setResizable(false);
	
}

}
class ListenToSearch extends searhClass implements ActionListener
{
String cls;Statement st;
Connection con;
ResultSet rs;
ListenToSearch(){rs=null;
con=null;
}
ListenToSearch(String cl){
cls=cl;
rs=null;
con=null;
}	
public void actionPerformed(ActionEvent ae)
	{
		JButton btn=(JButton)ae.getSource();
		if(btn.getText().equals("check"))
		{  
		    try{
Class.forName("com.mysql.cj.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"project"+"? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","143kinza"); 
   			st=con.createStatement();
	        rs=st.executeQuery("select * from classes where classs=" +cls);
			        while(rs.next())
					{
						String a=""+rs.getInt(1);
  row[0]=rs.getInt(1);
  row[1]=(rs.getString(2));
  row[2]=(rs.getString(3));
  row[3]=(rs.getString(4));
  row[4]=(rs.getString(5));
  row[5]=(rs.getString(6));
  row[6]=(rs.getString(7));
  row[7]=(rs.getString(8));
  row[8]=(rs.getString(9));
  row[9]=(rs.getString(10));
  row[10]=rs.getString(11);
  row[11]=(rs.getString(12));
		                model.addRow(row);
						
					}	
			
		   }catch(Exception ex){
		   System.out.println(ex);
		   }try
	{
con.close();
//st.close();
rs.close();
	}
catch(Exception ex)
{}
		   }
		else 
		if(btn.getText().equals("Cancel"))
		{
		jf.dispose();	
		}
		
	}
}



//-----------------RESULT  SEARCH-----------------------------
class searchResult{
Statement st;
Connection con;
ResultSet rs;
String grNo;
String name,n;Resultt ob;
searchResult(int gr,String name){

System.out.println("in constructor");
//System.out.println(gr);
grNo=Integer.toString(gr);
n=name;
}
 boolean flag=false;

 public void data_search()
		{
  try
	{

System.out.println("in search");
  Class.forName("com.mysql.cj.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"project"+"? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","143kinza"); 
  st=con.createStatement();
  String value="select * from results where grno=" +grNo;
  
   


  rs=st.executeQuery(value);
  while(rs.next())
	{
  flag=true;
  ob=new Resultt();
  System.out.println("in while");
  String a=""+rs.getInt(1);
  ob.stuGRTxt.setText(a);
  a=""+rs.getInt(2);
  ob.tMarksTxt.setText(a);
  ob.stuNameTxt.setText(rs.getString(3));
  a=""+rs.getInt(4);
  ob.scienceTxt.setText(a);
  a=""+rs.getInt(5);
  ob.mathsTxt.setText(a);
  a=""+rs.getInt(6);
  ob.engTxt.setText(a);
  a=""+rs.getInt(7);
  ob.urduTxt.setText(a);
  a=""+rs.getInt(8);
  ob.psTxt.setText(a);
  a=""+rs.getInt(9);
  ob.islamiatTxt.setText(a);
  a=""+rs.getInt(10);
  ob.drawTxt.setText(a);
  a=""+rs.getInt(11);
  ob.gMarksTxt.setText(a);
  

	}//while
if(!flag)
JOptionPane.showMessageDialog(null,"GR_NO is wrong");

	}//try

catch(Exception e){
JOptionPane.showMessageDialog(null,"GR_NO is wrong");System.out.println(e);
	}

try
	{
con.close();
st.close();
rs.close();
	}
catch(Exception ex)
{}
//now();
}

}









//--------------------------------CLASS  FOR  DATABASE  SEARCHING  AND DELETE--------------------------------------------------





class searchDataBase{

Statement st;
Connection con;
ResultSet rs;
String grNo;
String name;
searchDataBase(int gr){

//System.out.println(gr);
grNo=Integer.toString(gr);
}
 boolean flag=false;

 public void data_search()
		{
  try
	{

System.out.println("in search");
  Class.forName("com.mysql.cj.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"project"+"? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","143kinza"); 
  st=con.createStatement();
  String value="select * from classes where grno=" +grNo;
  
   nonedit ob;


  //System.out.println(value);
  rs=st.executeQuery(value);
  while(rs.next())
	{
  flag=true;
  ob=new nonedit();
  System.out.println("in while");
  String a=""+rs.getInt(1);
  ob.grTxt.setText(a);
  ob.nameTxt.setText(rs.getString(2));
  ob.F_nameTxt.setText(rs.getString(3));
  ob.addressTxt.setText(rs.getString(4));
  ob.surnameTxt.setText(rs.getString(5));
  ob.L_schoolTxt.setText(rs.getString(6));
  ob.R_LeavingSchoolTxt.setText(rs.getString(7));
  ob.classAddmissionTxt.setText(rs.getString(8));
  ob.classSecTxt.setText(rs.getString(9));
  ob.classSessionTxt.setText(rs.getString(10));
  String c=""+rs.getString(11);
  ob.C_numTxt.setText(c);
  ob.birth_DTxt.setText(rs.getString(12));

	}//while
if(!flag)
JOptionPane.showMessageDialog(null,"GR_NO is wrong");

	}//try

catch(Exception e){
JOptionPane.showMessageDialog(null,"GR_NO is wrong");System.out.println(e);
	}

try
	{
con.close();
st.close();
rs.close();
	}
catch(Exception ex)
{}
	}//method



public void db_delete(){
System.out.println("delete method");

  try
	{

System.out.println("in delete");
  Class.forName("com.mysql.cj.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"project"+"? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","143kinza"); 
st=con.createStatement();
 String value="delete from classes where grno=" +grNo;
 System.out.println(value);
 int d=st.executeUpdate(value);
if(d==1)
JOptionPane.showMessageDialog(null,"Your record is deleted");


}catch(Exception ex){
System.out.println(ex);
try
	{
con.close();
st.close();
rs.close();
	}
catch(Exception exp)
{System.out.println(exp);}
	

	}

}


}//class






//--------------------------CLASS  FOR  SEARCHING-DATA  FROM   DATABASE------------------------






class db_update{


Statement st;
Connection con;
ResultSet rs;
String grNo;
String name;
db_update(int gr){

//System.out.println(gr);
grNo=Integer.toString(gr);
}
 boolean flag=false;

 public void data_search()
		{
  try
	{

//System.out.println("In search");
  Class.forName("com.mysql.cj.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"project"+"? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","143kinza"); 
  st=con.createStatement();
  String value="select * from classes where grno=" +grNo;
  
   canEdit ob;


  //System.out.println(value);
  rs=st.executeQuery(value);

  while(rs.next())
	{
  flag=true;
  ob=new canEdit();
  System.out.println("in while");
  String a=""+rs.getInt(1);
  ob.grTxt.setText(a);
  ob.nameTxt.setText(rs.getString(2));
  ob.F_nameTxt.setText(rs.getString(3));
  ob.addressTxt.setText(rs.getString(4));
  ob.surnameTxt.setText(rs.getString(5));
  ob.L_schoolTxt.setText(rs.getString(6));
  ob.R_LeavingSchoolTxt.setText(rs.getString(7));
  ob.classAddmissionTxt.setText(rs.getString(8));
  ob.classSecTxt.setText(rs.getString(9));
  ob.classSessionTxt.setText(rs.getString(10));
  String c=""+rs.getString(11);
  ob.C_numTxt.setText(c);
  ob.birth_DTxt.setText(rs.getString(12));

	}//while
if(!flag)
JOptionPane.showMessageDialog(null,"GR_NO is wrong");

	}//try

catch(Exception ex){
JOptionPane.showMessageDialog(null,"GR_NO is wrong");
	}

try
	{
con.close();
st.close();
rs.close();
	}
catch(Exception ex)
{
System.out.println(ex);
}
	}//method



}





//-------------------------------CLASS   FOR   UPDATE------------------------------------------------





class update_class{

String name,fatherName,address,surName,leavingSchool,r_leavingSchool,className,sec,session;
int gr,contactNum;
String birth;
String Gr,conta,contct;
Connection con;
Statement st;
ResultSet rs;
update_class(String nameT,String F_nameT,String surnameT,int grno,String contact,String bir,String L_schoolT,String R_LeavingSchoolT,String addressT,String classAddmissionT,String classSecT,String classSessionT)
	{
gr=grno;
Gr=Integer.toString(gr);
name=nameT;
fatherName=F_nameT;
address=addressT;
surName=surnameT;
leavingSchool=L_schoolT;
r_leavingSchool=R_LeavingSchoolT;
className=classAddmissionT; 
sec=classSecT; 
session=classSessionT;
contct=contact; 
birth=bir;
}


public void update_Data(){

try{  

    Class.forName("com.mysql.cj.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"project"+"? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","143kinza"); 

st=con.createStatement();  
  String value=" Update classes set name=' "+(name)+" '  ,  FatherName=' "+(fatherName)+" ' , address=' "+(address)+" ' ,  surName=' "+(surName)+" ',  prevSchool=' "+(leavingSchool)+" ' ,  ReasonForLeaving=' "+(r_leavingSchool)+" ' ,  classs=' "+(className)+" ' , section=' "+(sec)+" ' , session=' "+(session)+" ' , contactNum=' "+(contct)+" ' , birthDate=' "+(birth)+" ' where grno= ' "+(Gr)+" ' ";
  		


int a=  st.executeUpdate(value);  
if(a==1)
JOptionPane.showMessageDialog(null,"Your record is updated!");
	}
catch(Exception ex){
JOptionPane.showMessageDialog(null,"Kindly fill in for all requirnments");
	}
try
	{
con.close();
st.close();
rs.close();
	}
catch(Exception ex)
{
}

      }


}