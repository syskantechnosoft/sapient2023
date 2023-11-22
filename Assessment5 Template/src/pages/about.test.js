import { render, screen } from "@testing-library/react";
import About from "./about";

test("renders About", () => {
  render(<About />);
  const aboutPage = screen.getByText(/About Page/i);
  expect(aboutPage).toBeInTheDocument();
});
