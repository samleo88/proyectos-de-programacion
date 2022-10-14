class CreateLibreta < ActiveRecord::Migration[5.2]
  def change
    create_table :libreta do |t|
      t.string :Nombre
      t.integer :Telefono

      t.timestamps
    end
  end
end
