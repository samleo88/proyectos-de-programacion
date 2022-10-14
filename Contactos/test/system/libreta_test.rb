require "application_system_test_case"

class LibretaTest < ApplicationSystemTestCase
  setup do
    @libretum = libreta(:one)
  end

  test "visiting the index" do
    visit libreta_url
    assert_selector "h1", text: "Libreta"
  end

  test "creating a Libretum" do
    visit libreta_url
    click_on "New Libretum"

    fill_in "Nombre", with: @libretum.Nombre
    fill_in "Telefono", with: @libretum.Telefono
    click_on "Create Libretum"

    assert_text "Libretum was successfully created"
    click_on "Back"
  end

  test "updating a Libretum" do
    visit libreta_url
    click_on "Edit", match: :first

    fill_in "Nombre", with: @libretum.Nombre
    fill_in "Telefono", with: @libretum.Telefono
    click_on "Update Libretum"

    assert_text "Libretum was successfully updated"
    click_on "Back"
  end

  test "destroying a Libretum" do
    visit libreta_url
    page.accept_confirm do
      click_on "Destroy", match: :first
    end

    assert_text "Libretum was successfully destroyed"
  end
end
