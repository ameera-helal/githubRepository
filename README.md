# githubRepository

gethubRepository is a java based android mobile application which display the top rated repositories that were created in the last 30 days.

## Installation

the application can be installed on any android mobile phone through its APK file.



## Used Libraries

volley:1.1.1

the application idea is based on importing the repositories data from Github JSON API and parse this data to disply it in a receyclerView.
Also, the user should be able to keep scrolling and new results should apear. 

## Note

the JSON data received from Github is paginated. Every page has a descending sorted repositories. But, you will miss this sorting while navigating from
one JSON page to another.

