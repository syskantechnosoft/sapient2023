import React, { useState, useEffect } from "react";
import accountArray from "../../model/account.json";
// import { useParams } from "react-router-dom";

const AccountList = (props) => {
  const [accounts, setAccounts] = useState({ id: 0 });
//   const params = useParams();
  const custId = props.customerId;

  useEffect(() => {
    let data1 = accountArray.filter((acc) => acc.customerId === props.customerId);
    console.log(
      "Mounting in Accounts Functional Component",
      "data:",
      data1,
      "custId:",
      custId,
      "props custId :", props.customerId
    );
    setAccounts(data1);
  }, [custId]);

  function tabRow() {
    const tableRows = accounts.map((acct, i) => {
      return (
        <tr key={i}>
          <td>{acct.id}</td>
          <td>{acct.accountNumber}</td>
          <td>{acct.accountType}</td>
          <td>{acct.balance}</td>
          <td>{acct.interestRate}</td>
        </tr>
      );
    });
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
