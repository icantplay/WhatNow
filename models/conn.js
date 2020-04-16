var sql = require("mssql");
var express = require('express');
var app = express();

// config for your database
var config = {
    user: 'sa',
    password: '1234567890',
    server: '192.168.1.69', 
    database: 'master',
    port: 1433
}

module.exports.config = config;
