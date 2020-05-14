
var db = require('./conn').pool;





module.exports.getEventInfo = function(callback, next) {
    db.getConnection(function(err, conn) {
      if (err) {
        conn.release();
        next(err);
      } else
        conn.query("Select Name, DateStart, DateEnd, Description From event", function(err, rows) {
         
          callback({ code: 200, status: "Ok" }, rows);
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
          
          callback({code: 200, status:"ok"},rows);
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
          
          callback({code: 200, status:"ok"},rows);
          conn.release();
          
        });
    });
  };
 
  module.exports.getSpotInfo = function(callback, next) {
    db.getConnection(function(err, conn) {
      if (err) {
        conn.release();
        next(err);
      } else
        conn.query("Select Name,Contact,Description,Website,Street,PostalCode,Town,Country From spot", function(err, rows) {
          
          callback({code: 200, status:"ok"},rows);
          conn.release();
          
        });
    });
  };
  

  module.exports.postLog = function(data,callback, next) {
    console.log(data);
    db.getConnection(function(err, conn) {
      if (err) {
        conn.release();
        next(err);
      } else
        conn.query("Insert into loghistory(Timestamp,ApplicationUserId,LogTypeId,Coordinates) Values(CURDATE(),?,4,Point(?,?))",[data.id,data.coordinates.x,data.coordinates.y], function(err, rows) {
          
          conn.release();
                if (err) {
                    console.log(err);
                    callback(err, { code: 500, status: "Error in a database query" });
                    return;
                }
                callback({ code: 200, status: "ok"});
            })
        
    })
  };
 






