import { render, screen } from "@testing-library/react";
import CustomerList from "./customerList";
import { MemoryRouter } from "react-router-dom";

test("renders Customer List", () => {
  render(
    <MemoryRouter>
      <CustomerList />
    </MemoryRouter>
  );
  const custListElement = screen.getByText(/Customer List Component!!!/i);
  expect(custListElement).toBeInTheDocument();
});
