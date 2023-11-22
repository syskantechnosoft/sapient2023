import { render, screen } from "@testing-library/react";
import CustomerForm from "./customerForm";

test("renders Customer Form", () => {
  render(<CustomerForm />);
  const custFormElement = screen.getByText(/Customer Form/i);
  expect(custFormElement).toBeInTheDocument();
});
