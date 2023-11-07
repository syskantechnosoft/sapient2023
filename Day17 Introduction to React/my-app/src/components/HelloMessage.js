import React, { Component } from 'react';

class HelloMessage extends Component {
    render() {
        const message = this.props.message ? this.props.message : 'Hi, Hello';
        return (
            <div>
                Hello {this.props.name}, {message}!!
            </div>
        );
    }
}

export default HelloMessage;
