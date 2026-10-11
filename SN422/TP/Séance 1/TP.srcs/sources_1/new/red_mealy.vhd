----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 09.10.2026 11:26:47
-- Design Name: 
-- Module Name: red_mealy - Behavioral
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

entity red_mealy is
    Port ( clk : in STD_LOGIC;
           rst : in STD_LOGIC;
           red_in : in STD_LOGIC;
           red_out : out STD_LOGIC);
end red_mealy;

architecture Behavioral of red_mealy is

type state_type is (s0, s1);

signal state : state_type := s0;
signal next_state : state_type := s0;

begin

process(clk, rst)
begin
    if (rst = '1') then
        state <= s0;
    else
        if (clk'event AND clk = '1') then
           state <= next_state;
        end if; 
    end if;
end process;

process(state, red_in)
begin
    next_state <= state;
    red_out <= '0';
    
    case state is
        when s0 =>
            if (red_in = '1') then
                red_out <= '1';
                next_state <= s1;
            else
                red_out <= '0';
                next_state <= s0;
            end if;
        when s1 =>
            if (red_in = '1') then
                red_out <= '0';
                next_state <= s1;
            else
                red_out <= '0';
                next_state <= s0;
            end if;
    end case;
end process;

end Behavioral;
