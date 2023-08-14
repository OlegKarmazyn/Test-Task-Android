# Test-Task-Android Level 2

<h1>Junior</h1>
Create Activity with RecyclerView with 7 hardcoded elements <br>
Every item is User, User has fields like this – Name, Age, isStudent (boolean field)<br>
Init isStudent = false for all users <br>

You should show the name, the age and the switcher/check box like the indicator if User is a student or not <br>
You can change the indicator from true to false<br>
When you scroll up/down, all indicators should save their status true/false<br>
You should store User after changing the screen orientation<br>
For saving User you can use DB or SharedPreferences<br>
After clicking on the user item from RecyclerView you should open Fragment with detailed info about the clicked User – Name, Age and isStudent. This Fragment is static, you can’t change isStudent status like in Activity<br>

<h1>Middle</h1>
/*Everything from Junior*/<br>
RecyclerView is empty<br>
You should add a toolbar with a menu, in menu you have 1 option – Add User<br>
After clicking add a user from the menu, you should open new Activity/Fragment with 2 Edit Text for Name, Age , DataPickeer for set date of birth in format dd/mm/yyyy and Button below <br>
After Clicking button, you should store this User in DB or SharedPreferences, close Activity/Fragment for adding and opening  previous Activity with Toast/SnackBar with text “User added successfully”<br>
Get Users from the store where you saved (DB or SharedPreferences) and Show the list of them in RecyclerView.<br>

<h1>Senior</h1>
/*Everything from Junior and Middle*/<br>
Long click on the user in RecyclerView should open Dialog with 2 buttons Yes and No and Tittle “You want to delete this User”<br>
If you click “Yes”, you should delete User from your store and update UI<br>
If you click “No”, you should close Dialog<br>
Add a new item to the toolbar – Sorting<br>
After clicking Sorting you should open Dialog with 3 TextView<br>
1 – Sort by name (Alphabetical)<br>
2 – Sort by age (youngest first)<br>
3 – Sort by student status (student first)<br>
After selecting the type of sort, you need to update UI and show Users in a chosen order<br>
