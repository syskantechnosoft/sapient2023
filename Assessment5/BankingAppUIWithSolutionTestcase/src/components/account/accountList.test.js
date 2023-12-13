import { render, screen } from "@testing-library/react";
import AccountList from "./accountList";

test("renders Account List", () => {
  render(<AccountList customerId="1" />);
  const acctListElement = screen.getByText(/Account List Component!!!/i);
  expect(acctListElement).toBeInTheDocument();
});
