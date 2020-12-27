<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Datepicker - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
</head>
<body>
<h2> Welcome TO FlyAway Project</h2>
<h4>prasuna.kanchi@gmail.com</h4>

<p>Please fill in the below details to continue..</p>

<form action="/webproject/getFlightDetails" method = "POST">

<p>Date: <input type="text" id="datepicker" name = "requestedDate"></p>
<p>Source: <input type="text"  id="source" name = "source"> </p>
<p>Destination : <input type="text"  id="destination" name = "destination"></p>
<p>No.Of Persons : <input type="text"  id="noOfPersons" name = "noOfPersons"></p>
 
     <input type="submit" value="submit">            
 </form>
</body>
</html>

