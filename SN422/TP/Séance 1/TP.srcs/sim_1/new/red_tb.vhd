----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 09.10.2026 10:52:10
-- Design Name: 
-- Module Name: red_tb - Behavioral
-- Project Name: 
-- Target Devices: 
-- Tool Versions: 
-- Description: 
-- 
-- Dependencies: 
-- 
-- Revision:
-- Revision 0.01 - File Created
-- Additional Comments:
-- 
----------------------------------------------------------------------------------


library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx leaf cells in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity red_tb is
--  Port ( );
end red_tb;

architecture Behavioral of red_tb is

component red_mealy is
port(
        clk : in STD_LOGIC;
        rst : in STD_LOGIC;
        red_in : in STD_LOGIC;
        red_out : out STD_LOGIC
    );
end component;

signal clk, rst, red_in, red_out : STD_LOGIC := '0';

begin

dut : red_mealy
port map(
        clk => clk,
        rst => rst,
        red_in => red_in,
        red_out => red_out
        );



clk_process : process is
begin
    wait for 5ns;
    clk <= not clk;
end process;


stimulus_process : process is
begin
    wait for 3 ns;
    red_in <= '1';
    wait for 18 ns;
    red_in <= '0';
    wait for 5 ns;
    red_in <= '1';
    wait for 1 ns;
    red_in <= '0';
    wait for 4 ns;
    red_in <= '1';
    wait for 5 ns;
    rst <= '1';
    wait for 3 ns;
    rst <= '0';
end process;
    

end Behavioral;
