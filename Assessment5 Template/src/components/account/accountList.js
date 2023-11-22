import React, { useState, useEffect } from "react";
import accountArray from "../../model/account.json";

const AccountList = (props) => {
  const [accounts, setAccounts] = useState({ id: 0 });
  const custId = props.customerId;

  useEffect(() => {
    let data1 = accountArray.filter((acc) => acc.customerId === props.customerId);   
    setAccounts(data1);
  }, [custId]);

  function tabRow() {
    const tableRows ={
      // Add missing code here to display account details of selected customer
    }; 
    return tableRows;
  }

  return (
    <div>
      Account List Component!!!
      <div>
        <h4>List of Accounts</h4>
        <table className="table table-bordered table-sm">
          <thead>
            <tr>
              <th>Account ID </th>
              <th>Account Number</th>
              <th>Account Type</th>
              <th>Account Balance </th>
              <th>Interest Rate </th>
            </tr>
          </thead>
          <tbody>{accounts.id !== 0 ? tabRow() : null}</tbody>
        </table>
      </div>
    </div>
  );
};

export default AccountList;
