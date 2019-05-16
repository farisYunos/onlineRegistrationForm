<%@ page import="java.util.*"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.pfs.demo.util.Student" %>





<%
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String gender = request.getParameter("gender");
    String address = request.getParameter("address");
    String phoneNo = request.getParameter("phoneNo");
    String course = request.getParameter("course");

       /* out.println(firstName);
        out.println(lastName);
        out.println(gender);
        out.println(address);
        out.println(phoneNo);
        out.println(course);

        */

        Student student = new Student();

                int ph = Integer.parseInt(phoneNo);


                student.setStudent_FirstName(firstName);
                student.setStudent_LastName(lastName);
                student.setGender(gender);
                student.setResidential_Address(address);
                student.setPhoneNo(ph);
                student.setCourse_Id(Integer.parseInt(course));

                 try {
                            student.insertStudent();
                        } catch (ClassNotFoundException e) {
                           out.println(e.getMessage());
                        } catch (SQLException e) {
                            out.println(e.getMessage());
                        }


        %>

        <html>

        <body>
        <h1>Thank you for registering!</h1>
        </body>




        </html>