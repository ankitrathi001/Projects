Distributed Software Development - Yinong Chen

Project 5 - Final Part

Description of the Web Application:

For the Project 5, we have developed a web application, which allows members or users to use services when they register with the application. The following are the web pages in our project: 

a. Default page. This is a public page, and it introduces clearly what functionality the system offers, how end users can sign up for the services, how the users (TA) can test this application and what are the test cases/inputs. All the components and services used in the application are listed in a “Service Directory”. 
b. Member page: Users can register (self-subscribe) to obtain the access to this page. An image verifier is used when a new user signs up. We created our own access control component and stored the credentials in an XML file.
c. Admin page: This page allows the administrator to add user name, password, and a role into an XML file. There are two possible roles: Manager and Staff. The password is encrypted or hashed when adding into the XML file. Only the administrator can access this page. For the TA to test this page, the admin credential to test this page: User name: TA and Password: CSE445598ta!
d. Manage and Staff pages: We have provided authentication and authorization access control. The managers can access both Manager and Staff pages, and in addition, manager can see the profiles of all staff members, while the staff members can access the Staff page only. The user name, password, and role are stored in an XML file that is maintained by the administrator. 

HOME PAGE OF THE APPLICATION : http://webstrar42.fulton.asu.edu/page0/

