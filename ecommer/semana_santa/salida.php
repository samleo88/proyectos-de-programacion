<?php

session_start();
session_destroy(); 
session_unset();

//error_reporting(0);

echo "<script>
alert('Suerte es que le digo');
location.href='login.php';
</script>";
exit;
?>