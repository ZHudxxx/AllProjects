<html>
<body>
<table border=1>
<tr><th>mid</th><th>name</th><th>uname</th><th>pword</th></tr>
<?php
$uname= $_POST['uname'];
$pword= $_POST['pword'];
$con= mysqli_connect('localhost','root','','mysystem') or die("unable to connect to DB");
$sql ="select * from members where uname='$uname' and pword='$pword'";
$res = mysql_query($con,$sql);
while($r=mysqli_fetch_array($res));
echo "<tr><td>".$r['mid']."</td><td>".$r['name']."</td><td>".$r['uname']."</td></tr>"</td><td>".$r['pword']."</td></tr>";
mysqli_free_result($res);
mysqli_close($con);
?>
</table>
</body>
</html>