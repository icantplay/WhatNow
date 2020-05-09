
var db = require('./conn').pool;





module.exports.getEventInfo = function(callback, next) {
    db.getConnection(function(err, conn) {
      if (err) {
        conn.release();
        next(err);
      } else
        conn.query("Select Name, DateStart, DateEnd, Description From event", function(err, rows) {
          console.log(rows);
          callback(false, {code: 200, status:"ok", data: rows})
          conn.release();
          
        });
    });
  };
  module.exports.getEventfullInfo = function(id,callback, next) {
    db.getConnection(function(err, conn) {
      if (err) {
        conn.release();
        next(err);
      } else
        conn.query("Select Description From event Where id = " +id, function(err, rows) {
          
          callback(false, {code: 200, status:"ok", data: rows})
          conn.release();
          
        });
    });
  };
 

  module.exports.getUsername = function(callback, next) {
    db.getConnection(function(err, conn) {
      if (err) {
        conn.release();
        next(err);
      } else
        conn.query("Select Name From applicationuser", function(err, rows) {
          
          callback(false, {code: 200, status:"ok", data: rows})
          conn.release();
          
        });
    });
  };
 

  







