var mysql = require("mysql");
var express = require('express');
var app = express();


var pool = mysql.createPool({
    host: 'remotemysql.com',
    user: '99BVw3APBg',
    password: 'jdz6HQqGOZ',
    database: '99BVw3APBg'
});
exports.pool = pool;