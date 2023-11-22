import { render, screen } from "@testing-library/react";
import NavBar from "./navBar";
import { MemoryRouter } from "react-router-dom";

test("renders NavBar", () => {
  render(
    <MemoryRouter>
      <NavBar />
    </MemoryRouter>
  );
  const navElement = screen.getByText(/Banking App/i);
  expect(navElement).toBeInTheDocument();
});
