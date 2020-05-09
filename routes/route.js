var express = require('express');
var app = express();
var router = express.Router();
var whatnowDAO = require('../models/whatnowDAO');



router.get('/EventInfo',function(req,res,next){
    whatnowDAO.getEventInfo(function(err,result){
        console.log(result);
        res.send(result);
        
    })
});

router.get('/EventfullInfo/:id',function(req,res,next){
    whatnowDAO.getEventfullInfo(req.params.id,function(err,result){
        res.send(result);
      
    })
});


router.post('/login', function(req,res,next){
    whatnowDAO.login(req.body,function(status,result){
        
        if(status.code==200)
        res.send(result);
        else{
            res.statusMessage = status.status;
            res.status(status.code).send({});
        }
    });
});

router.get('/Username',function(req,res,next){
    whatnowDAO.getUsername(function(err,result){
        console.log(result);
        res.send(result);
        
    })
});


module.exports = router;