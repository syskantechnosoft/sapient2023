import React, { Component } from 'react';

class Alert extends Component {
    showAlert() {
        alert("React is a Great UI Library");
    }
    render() {
        return (
            <div>
                <button onClick={this.showAlert}>Click Me!!</button>
            </div>
        );
    }
}

export default Alert;
