# Start code for 1st week on 3rd semester
## Steps to follow:
1. Fork this repository and clone it to your local machine
2. Create a new repository on github and push your code to it
3. In POM.xml:
  - Change the groupId to your github username
  - Change the artifactId to the name of your new repository
  - Change remote.server to your droplet IP:8081/manager/text
4. Go to github and create 2 new repository secrets:
  - REMOTE_USER
  - REMOTE_PW
  - to represent your tomcat username and password on your droplet
5. On your droplet, create a new table in your startcode database:
```sql
CREATE TABLE IF NOT EXISTS `usertable` (
`id` INT NOT NULL AUTO_INCREMENT,
`fname` VARCHAR(45) NULL,
`lname` VARCHAR(45) NULL,
`pw` VARCHAR(45) NULL,
`phone` VARCHAR(45) NULL,
`address` VARCHAR(45) NULL,
PRIMARY KEY (`id`));
INSERT INTO usertable (fname, lname, pw, phone, address) 
VALUES ('Helge','Kaspersen','Hemmelig123','40434343','Gammel Landevej 1'),
('Hulje','Harps','Hemmlig321','40545454','Gl. Strandvej 1');
```
6. Push your code to github and check that the build is successful on github
7. Check that your code is deployed on your droplet and that you can see the 2 users on the index page.
8. Hint: on your droplet, you can check your log file with: `docker logs tomcat_3sem`
9. Hint: on your droplet, you can check your database with: `docker exec -it mysql_3sem mysql -u root -p` and then enter your password