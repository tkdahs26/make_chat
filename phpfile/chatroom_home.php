
<?php
$connect=mysqli_connect("localhost","tidahk","wiatnpfa*8","tidahk");


$sql = "SELECT * FROM $_POST[title_php] "; 
$query=mysqli_query($connect,$sql);
$data=array();
while($row=mysqli_fetch_array($query)){
    array_push($data,array('index'=>$row[0],
        'make_user_id'=>$row[1],
        'make_other_id'=>$row[2]
));
}
header('Content-Type: application/json; charset=utf8');
$json = json_encode(array("result"=>$data), JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE);
echo $json;
    mysqli_close($connect);





?>
