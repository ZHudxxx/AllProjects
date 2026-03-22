<html>
<body>
<?php
$h=$_POST['h'];
$w=$_POST['w'];
$bmi = $w/($h*$h);
$cat = "";
if ($bmi<18.5) $cat = "Underweight";
else if ($bmi<25.0) $cat = "Normal weight";
else if ($bmi<30.0) $cat = "Over weight";
else if ($bmi<35.0) $cat = "Obesity Class I";
else if ($bmi<40.0) $cat = "Obesity Class II";
else $cat = "Obesity Class III";
echo "BMI : $bmi \nCategory : $cat";
?>
</body>
</html>