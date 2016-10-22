var express = require('express');
var app = express();
var sphero = require('sphero');

bb8 = sphero("c1f4442483284d58a7409cecdcfd6d5c");

bb8.connect(function() {
    console.log('Connected to BB-8!');
    bb8.color("white");
});

var server = app.listen(8081, function() {
    var host = server.address().address;
    var port = server.address().port;
});

app.get('/player-hurt', function(req, res) {
    bb8.color("red")
        .delay(200)
        .then(function() {
            return bb8.color("white");
        });

    res.end();
});

app.get('/player-jump', function(req, res) {
	var direction = Math.floor(Math.random() * 360);
	bb8.roll(0, direction);

    res.end();
});