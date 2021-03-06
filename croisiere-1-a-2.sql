--
-- PostgreSQL database dump
--

-- Dumped from database version 12.4
-- Dumped by pg_dump version 12.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: croisiere; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE croisiere WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'French_Canada.1252' LC_CTYPE = 'French_Canada.1252';


ALTER DATABASE croisiere OWNER TO postgres;

\connect croisiere

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: commentaire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.commentaire (
    id integer NOT NULL,
    titre text,
    auteur text,
    contenu text,
    date timestamp without time zone
);


ALTER TABLE public.commentaire OWNER TO postgres;

--
-- Name: commentaire_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.commentaire_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.commentaire_id_seq OWNER TO postgres;

--
-- Name: commentaire_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.commentaire_id_seq OWNED BY public.commentaire.id;


--
-- Name: commentaire id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire ALTER COLUMN id SET DEFAULT nextval('public.commentaire_id_seq'::regclass);


--
-- Data for Name: commentaire; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.commentaire VALUES (1, 'Meilleure voyage de ma vie', 'Jean-Luc Pelletier', 'La croisière a été parfaite. Ma famille et moi avons adoré.', '2020-09-22 14:00:00');
INSERT INTO public.commentaire VALUES (2, 'Des vacances agréables', 'Eric Mark', 'Vraiment des vacances très agréables pour toute la famille ! Le service était très bon, les activités diverses et variées. ├Ç refaire un de ces quatre', '2020-09-23 09:30:00');
INSERT INTO public.commentaire VALUES (3, 'Très déçu du service', 'James Palet', 'Le personnel a été très insolent avec mes enfants. Je ne reviendrai jamais sur ce bateau !', '2020-09-23 11:00:00');
INSERT INTO public.commentaire VALUES (4, 'Ne prenez pas ce bateau !', 'Annie Proust', 'C''était vraiment une expérience désagréable pour moi et mon mari. La qualité des services laisse vraiment à désirer', '2020-09-24 15:00:00');
INSERT INTO public.commentaire VALUES (5, 'Le rêêêveee !!', 'Pierre Tremblay', 'Ne réfléchissez plus. Foncez. Venez sur ce magnifique bateau. Monsieur Poisson vous recevra avec sympathie !', '2020-09-24 16:00:00');
INSERT INTO public.commentaire VALUES (6, 'Pas mal !', 'Mélanie Argé', 'Vraiment pas mal comme croisière ', '2020-09-29 16:00:00');
INSERT INTO public.commentaire VALUES (7, 'Cool', 'Anonyme', 'C''était vraiment chouette', '2020-09-30 12:00:00');
INSERT INTO public.commentaire VALUES (8, 'Décevant', 'Marie-Pierre Desjardins', 'Vraiment décevant comme voyage. Je souhaite que ça s''améliore pour les prochaines années', '2020-10-01 08:00:00');
INSERT INTO public.commentaire VALUES (9, 'PARFAIT !', 'Jacques Chicar', 'Honnêtement le plus beau voyage de ma vie.', '2020-10-01 13:30:00');
INSERT INTO public.commentaire VALUES (10, 'Nul', 'Meredith Poquet', 'Nul. Absurde. Vraiment très très nul', '2020-10-01 14:30:00');
INSERT INTO public.commentaire VALUES (11, 'Joli vue sur les lieux d''intérêts', 'Patrick Smith', 'Je ne pensais pas voir d''aussi belles choses dans ma vie', '2020-10-01 19:30:00');
INSERT INTO public.commentaire VALUES (12, 'À refaire', 'Jordan Caleb', 'C''est cool, j''ai laissé un commentaire', '2020-10-01 19:31:00');
INSERT INTO public.commentaire VALUES (13, 'Super chouette', 'Marie Bernard', 'J''ai adoré la croisière. Les points de vue étaient magnifiques.', '2020-10-01 19:53:11');
INSERT INTO public.commentaire VALUES (14, 'Je recommande vivement cette croisière', 'Jean-Luc Patou', 'Vraiment un joli voyage en compagnie de personnes fort sympathique.
├Ç refaire !', '2020-10-01 20:39:03');
INSERT INTO public.commentaire VALUES (15, 'Je voudrais revenir plus tard', 'Marie Carlos', 'J''ai bien aimé la croisière mais beaucoup de choses laissent encore à désirer. J''aimerais revenir quand tout sera bien réglé.', '2020-10-06 15:48:37.823');


--
-- Name: commentaire_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.commentaire_id_seq', 15, true);


--
-- Name: commentaire commentaire_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT commentaire_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

