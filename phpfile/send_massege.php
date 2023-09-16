
<?php
$connect=mysqli_connect("localhost","tidahk","wiatnpfa*8","tidahk");


echo $_POST['room_title'];
echo $_POST['writer_id_php'];
echo $_POST['other_id_php'];
echo $_POST['write_text_php'];

$sql="INSERT INTO $_POST[room_title]($_POST[writer_id_php],$_POST[other_id_php]) 
VALUES ('$_POST[write_text_php]','xxx')";


$query=mysqli_query($connect,$sql);



?>
