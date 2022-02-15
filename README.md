# Evive-Problem

This is a repo for the Evive technical interview problem. The main program is run through the Program.java file.

The structure is based around a Menu interface in which all necessary functions for the problem's solution are defined. The Breakfast, Lunch, and Dinner class are defined 
with their own variations of each method, as the problem required each meal type to have different parameters for their structure. With the Menu interface, it allows for the code to follow
a unified structure for each class that can be used in further classes if necessary. With this as well, a Menu object is able to be created, and the methods called in a generic way, with their
results creating an outcome that satisfies the requirements of each meal type.

Test.java is a basic testing script that was used to test that each class produces outcomes that are expected given a certain input.
