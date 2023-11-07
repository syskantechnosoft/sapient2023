import React from "react";

function CustomerDetails(props) {
  const customer = props.customer;
  return (
    <div>
      <h3>Customer Details</h3>
      <hr />
      <div>
        <p>ID : {customer.id}</p>
        <p>FirstName : {customer.firstName}</p>
        <p>LastName : {customer.lastName}</p>
        <p>EMail : {customer.email}</p>
      </div>
    </div>
  );
}

export default CustomerDetails;
