
<?php
$connect=mysqli_connect("localhost","tidahk","wiatnpfa*8","tidahk");




$sql1 = "SELECT * FROM homepage_table";
$query1=mysqli_query($connect,$sql1);

    $data=array();
    while($row=mysqli_fetch_array($query1)){
        array_push($data,array('index'=>$row[0],
            'room_name'=>$row[1],
            'room_password'=>$row[2],
            'user_id'=>$row[3],
            'other_id'=>$row[4]
    ));
}



header('Content-Type: application/json; charset=utf8');
$json = json_encode(array("result"=>$data), JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE);
echo $json;
    mysqli_close($connect);




?>
