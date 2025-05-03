
<?php


$connect=mysqli_connect("localhost","tidahk","wiatnpfa*8","tidahk");


$sql = "SELECT * FROM homepage_table WHERE room_password_db	='{$_POST['room_password_php']}'";

$query=mysqli_query($connect,$sql);

while($row=mysqli_fetch_array($query)){
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
