public class ComplexMethod {

    public void doGet(HttpServletRequest req,
HttpServletResponse res)
{
	String age = "age";
String name = req.getParameter("username");
String pwd = req.getParameter("password");

// SQL Injection
int id = validateUser(username, password);

// XSS
String retstr = "User : " + name + " has ID: " + id;
res.getOutputStream().write(retstr.getBytes());
}

private int validateUser(String user, String pwd)
throws Exception
{
Statement stmt = myConnection.createStatement();
ResultSet rs;

rs = stmt.executeQuery("select id from users where
user='" + user + "' and key='" + pwd + "'");
return rs.next() ? rs.getInt(1) : -1;
}
}