----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 09.10.2026 09:03:13
-- Design Name: 
-- Module Name: synchronizer_tb - Behavioral
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

entity synchronizer_tb is
--  Port ( );
end synchronizer_tb;

architecture Behavioral of synchronizer_tb is

component synchronizer is
port(
        clk : in STD_LOGIC;
        rst : in STD_LOGIC;
        sync_in : in STD_LOGIC;
        sync_out : out STD_LOGIC
    );
end component;

signal clk, rst, sync_in, sync_out : STD_LOGIC := '0';


begin
dut : synchronizer
port map (
    clk => clk,
    rst => rst,
    sync_in => sync_in,
    sync_out => sync_out
    );
   
  
 


clk_process : process is
begin
    wait for 5ns;
    clk <= not clk;
end process;

stimulus_process : process is
begin
    wait for 5000 ps;
    sync_in <= '1';
    wait for 7 ns;
    sync_in <= '0';
    wait for 13001 ps;
    sync_in <= '1';
    wait for 22 ns;
    rst <= '1';
    wait for 5 ns;
    sync_in <= '0';
    wait for 15 ns;
    rst <= '0';
end process;


end Behavioral;
