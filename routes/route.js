var express = require('express');
var app = express();
var router = express.Router();
var whatnowDAO = require('../models/whatnowDAO');


router.get('/puta',function(req,res,next){
    whatnowDAO.getApplicationUser(function(err,result){
        res.send(result);
        console.log(result);
    })
});
router.get('/EventInfo',function(req,res,next){
    whatnowDAO.getEventInfo(function(err,result){
       
        res.send(result);
        
    })
});

router.get('/EventfullInfo/:id',function(req,res,next){
    whatnowDAO.getEventfullInfo(req.params.id,function(err,result){
        res.send(result);
      
    })
});


module.exports = router;