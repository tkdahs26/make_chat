	
<?php
$connect=mysqli_connect("localhost","tidahk","wiatnpfa*8","tidahk");




$sql1 = "UPDATE writedb SET title_db ='{$_POST['fixtitle_php']}'
,content_db='{$_POST['fixcontent_php']}' WHERE count ='{$_POST['id_php']}';";
$query1=mysqli_query($connect,$sql1);
var_dump($query1)


?>
