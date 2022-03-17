<h1>Book catalog parser (.xml)</h1>
<h2>Description</h2>
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

<h2>Data import to database</h2>
The application supports the import of parsed data into the <b>PostgreSQL</b> database.
<ul><li> Eliminate duplicates on both sides.</li>
<li> Batch data processing for better performance.</li></ul>
<br>
<br><em>Book table</em>

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
<h2>Application settings</h2>

1. Connection to database

To connect to the database, enter your personal data in the file **database.properties**
```
resources -> database.properties
```
2. Application start

![](https://sun9-64.userapi.com/impf/KNLfkq7aZeqWKjIox0gpmIdv_9qe6piaWKE6tg/ViAv8HEthJQ.jpg?size=593x313&quality=96&sign=74a9c89f78da60de28ef7d010a1b9fc9&type=album)
