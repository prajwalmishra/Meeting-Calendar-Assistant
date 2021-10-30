# Meeting-Calendar-Assistant
### A calendar assistant is a program that assists the calendar owner and helps other users book meeting with him and help them finding meeting conflicts.

#### there are 3 end points for the program

#### 1. A POST request to create a meeting ("/createMeeting"). It solves the problem (Book meeting with calendar Owner (Each employee is the owner of his calendar))
#####    You have to pass meeting object in JSON format as 
#####         "employeeName":"", it has the type String
#####          "meetingDate":"", it has the type Date (yyyy-mm-dd)
#####          "meetingStartTime":"", it has the type Time (hh:mm:ss)
#####          "meetingEndTime":"" it has the type Time (hh:mm:ss)


#### 2. A GET request to check free slots between two employees given their names, and meeting date ("/checkFreeSlots") . It solves the problem (Given the calendar of 2 employees as input, find out the free slots where
#### a meeting of a fixed duration (say half an hour) can be scheduled)
#####    You have to pass findFreeSlots object in JSON format as 
#####         "employee1Name":"", it has the type String
#####         "employee2Name":"", it has the type String
#####          "meetingDate":"", it has the type Date (yyyy-mm-dd)

#### 2. A GET request to check free slots between two employees given their names, and meeting date ("/checkFreeSlots") . It solves the problem (Given the calendar of 2 employees as input, find out the free slots where
#### a meeting of a fixed duration (say half an hour) can be scheduled)
#####    You have to pass findFreeSlots object in JSON format as 
#####         "employee1Name":"", it has the type String
#####         "employee2Name":"", it has the type String
#####          "meetingDate":"", it has the type Date (yyyy-mm-dd)

#### 3. A GET request to check all employess which has meeting conflict given a meeting request  ("/meetingRequest") . It solves the problem (Given a meeting request, find out all participants have meeting conflicts)
#####    You have to pass meeting object in JSON format but excluding the emloyeeName 
#####          "meetingDate":"", it has the type Date (yyyy-mm-dd)
#####          "meetingStartTime":"", it has the type Time (hh:mm:ss)
#####          "meetingEndTime":"" it has the type Time (hh:mm:ss)

### Test Cases are implemented only for Service layer Currently.
         
