##Book catalog parser (.xml)
###Description
This is an application for parsing a book catalog presented in the following format:
```
<catalog>
    <book vendor_code="bk101">
        <author>Gambardella, Matthew</author>
        <title>XML Developer's Guide</title>
        <genre>Computer</genre>
        <price>44.95</price>
        <publish_date>2000-10-01</publish_date>
        <description>An in-depth look at creating applications
            with XML.</description>
    </book>
</catalog>
```
###Data import to database
The application supports the import of parsed data into the **PostgreSQL** database.
* Eliminate duplicates on both sides.
* Batch data processing for better performance.
<br>
<br>_Book table_
```
CREATE TABLE Books
(
    id          serial  not null,
    vendorCode  text    not null,
    author      text    not null,
    title       text    not null,
    genre       text    not null,
    price       numeric not null,
    publishDate date    not null,
    description text    not null
)
```
![](https://sun9-19.userapi.com/impf/v4aYO6KSneFhLDLxsHnpD9b0dYP5Q2bHEdEf2w/BCgCmKKdlFo.jpg?size=692x426&quality=96&sign=e8dead301e3bcafff43b0840c1a93f4e&type=album)
###Application settings
1. Connection to database

To connect to the database, enter your personal data in the file **database.properties**
```
resources -> database.properties
```
2. Application start

![](https://sun9-64.userapi.com/impf/KNLfkq7aZeqWKjIox0gpmIdv_9qe6piaWKE6tg/ViAv8HEthJQ.jpg?size=593x313&quality=96&sign=74a9c89f78da60de28ef7d010a1b9fc9&type=album)
