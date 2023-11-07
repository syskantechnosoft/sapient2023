import React, { Component } from 'react';

class Counter extends Component {
    constructor(props){
        super(props);
        this.state = {
            seconds : 0
        }
       
    }

    tick() {
        this.setState( 
            {
                seconds : this.state.seconds+1
            }
        );
    }

    componentDidMount(){
        setInterval(()=>{this.tick()},1000);
    }

    render() {
        return (
            <div>
                <div> Time Elapsed : {this.state.seconds}</div>
            </div>
        );
    }
}

export default Counter;
