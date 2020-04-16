var express = require('express');
var app = express();
var config = require('./conn').config;
var sql = require("mssql");

module.exports.getApplicationUser = function (callback, next) {



    // connect to your database
    sql.connect(config, function (err) {

        if (err) console.log(err);

        // create Request object
        var request = new sql.Request();

        // query to the database and get the records
        request.query('select * from ApplicationUser', function (err, recordset) {
            console.log(recordset);
            if (err) console.log(err)

            // send records as a response
            callback(false, { code: 200, status: "ok", data: recordset });

        });
    });

}
module.exports.getEventInfo = function (callback, next) {
    // connect to your database
    sql.connect(config, function (err) {

        if (err) console.log(err);

        // create Request object
        var request = new sql.Request();

        // query to the database and get the records
        request.query('select Name, DateStart, DateEnd from Event', function (err, recordset) {
            
            if (err) console.log(err)

            // send records as a response
            callback(false, { code: 200, status: "ok", data :recordset });

        });
    });

}

module.exports.getEventfullInfo = function (id, callback, next) {

    sql.connect(config, function (err) {

        if (err) console.log(err);
        var request = new sql.Request();
        request.query("select Description from Event where Id = " + id, function (err, recordset) {
            if (err) console.log(err)
            callback(false, { code: 200, status: "ok", data: recordset });

        });
    });
}