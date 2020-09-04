 

let x = {
   a:666,
   foo : function(){return this.a},
   goo(){return this.a},
   hoo: () => this.a,
   joo: function(){
          let arrow = () => this.a
          return arrow()
   }       
}

module.exports = x

