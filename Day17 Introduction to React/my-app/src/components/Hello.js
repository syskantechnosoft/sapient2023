import React from 'react';

const Hello = () => {
    const numbers = [23,45,67,34,78];
    const listNumber = numbers.map((number)=><li>{number}</li>);
    return (
        <div>
            <h1>Hello World Component</h1>
            <ul>{listNumber}</ul>
        </div>
    );
}

export default Hello;
