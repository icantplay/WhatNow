var express = require('express');
var app = express();
var router = express.Router();
var whatnowDAO = require('../models/whatnowDAO');



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

router.get('/EventbyContact/:id',function(req,res,next){
    whatnowDAO.getEventbyContact(req.params.id,function(err,result){
        
        res.send(result);
        
    })
});
router.post('/Rating', function(req,res,next){
    whatnowDAO.postEventRating(req.body,function(status,result){
        console.log(req.body);
        if(status.code==200)
        res.send(result);
    
        else{
            res.statusMessage = status.status;
            res.status(status.code).send({});
        }
    });
});
//New Router

router.get('/SpotInfo',function(req,res,next){
    whatnowDAO.getSpotInfo(function(err,result){
        
        res.send(result);
        
    })
});

router.get('/SpotbyContact/:id',function(req,res,next){
    whatnowDAO.getSpotbyContact(req.params.id,function(err,result){
        
        res.send(result);
        
    })
});




// New router


router.get('/Admin',function(req,res,next){
    whatnowDAO.getAdmin(function(err,result){
        
        res.send(result);
        
    })
});

router.get('/Username',function(req,res,next){
    whatnowDAO.getUsername(function(err,result){
        
        res.send(result);
        
    })
});
router.post('/Loghistory', function(req,res,next){
    whatnowDAO.postLog(req.body,function(status,result){
        console.log(req.body);
        if(status.code==200)
        res.send(result);
    
        else{
            res.statusMessage = status.status;
            res.status(status.code).send({});
        }
    });
});

module.exports = router;