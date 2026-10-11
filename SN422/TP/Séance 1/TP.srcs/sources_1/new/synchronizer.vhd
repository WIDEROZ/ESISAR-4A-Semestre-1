----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 09.10.2026 08:41:04
-- Design Name: 
-- Module Name: synchronizer - Behavioral
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

entity synchronizer is
    Port ( 
           clk : in STD_LOGIC;
           rst : in STD_LOGIC;
           sync_in : in STD_LOGIC;
           sync_out : out STD_LOGIC
         );
end synchronizer;

architecture Structural of synchronizer is
component FlipFlop is
    port(
        clk : in STD_LOGIC;
        rst : in STD_LOGIC;
        D : in STD_LOGIC;
        Q : out STD_LOGIC
    );
end component;


signal internal_signal : STD_LOGIC;


begin
FLIP_FLOP_1 : FlipFlop
port map(
    clk => clk,
    rst => rst,
    D => sync_in,
    Q => internal_signal
);


FLIP_FLOP_2 : FlipFlop
port map(
    clk => clk,
    rst => rst,
    D => internal_signal,
    Q => sync_out
);

end Structural;
