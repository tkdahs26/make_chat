<?php

$connect=mysqli_connect("localhost","tidahk","wiatnpfa*8","tidahk");


$sql = "INSERT INTO homepage_table(title_db,room_password_db,userid_db,otherid_db,empty1)
VALUES('$_POST[room_name_php]','$_POST[room_password_php]','$_POST[userid_php]','$_POST[otherid_php]','empty')";
$query=mysqli_query($connect,$sql);
$sql2 ="CREATE TABLE $_POST[room_name_php](
    count int(11) NOT NULL AUTO_INCREMENT,
    $_POST[userid_php] VARCHAR(2000) NOT NULL,
    $_POST[otherid_php] VARCHAR(2000) NOT NULL,
    PRIMARY KEY(count)
    )"; 

$query2=mysqli_query($connect,$sql2); 

$sql3 = "SELECT * FROM homepage_table  WHERE title_db='{$_POST['room_name_php']}'"; 
$query3=mysqli_query($connect,$sql3);


while($row=mysqli_fetch_array($query3)){
    $data = array('index'=>$row[0],
    'title_db'=>$row[1],
    'room_password_db'=>$row[2],
    'userid_db'=>$row[3],
    'otherid_db'=>$row[4],
    'empty1'=>$row[5]
);
}
header('Content-Type: application/json; charset=utf8');
$json = json_encode(array("result"=>$data), JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE);
echo $json;




?>
